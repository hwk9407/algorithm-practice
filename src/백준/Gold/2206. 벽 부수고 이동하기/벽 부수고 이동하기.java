import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        int x, y;
        boolean isBroken;
        int cnt;
        public Node (int x, int y, boolean isBroken, int cnt) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        boolean[][][] visited = new boolean[N][M][2];
        Deque<Node> q = new ArrayDeque<>();
        visited[0][0][0] = true;
        q.offerLast(new Node(0, 0, false, 1));
        int result = -1;
        while (!q.isEmpty()) {
            Node current = q.pollFirst();

            if (current.x == M - 1 && current.y == N - 1) {
                result = current.cnt;
                break;
            }
            for(int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                boolean currentBroken = current.isBroken;
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (maps[ny][nx] == 1) {
                    if (currentBroken) continue;
                    currentBroken = true;
                }
                int brokenState = currentBroken ? 1 : 0;
                if (visited[ny][nx][brokenState]) continue;
                visited[ny][nx][brokenState] = true;
                q.offerLast(new Node(nx, ny, currentBroken, current.cnt + 1));
            }
        }

        System.out.println(result);
    }
}
