import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        int x;
        int y;
        int distance;

        public Node (int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maps = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }
        boolean[][] visited = new boolean[n][m];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0, 0, 1));
        visited[0][0] = true;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        while (!queue.isEmpty()) {
            Node current = queue.pollFirst();

            if (current.x == m - 1 && current.y == n - 1) {
                System.out.println(current.distance);
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.offerLast(new Node(nx, ny, current.distance + 1));
            }
        }
    }
}