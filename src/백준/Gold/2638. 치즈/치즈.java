import java.util.*;
import java.io.*;

public class Main {
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로
        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) maps[i][j] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        while (true) {
            externalAir(maps);
            boolean hasCheeze = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j] == 1) {
                        hasCheeze = true;
                        if (isMeltCheeze(maps, j, i)) maps[i][j] = 0;
                    }
                }
            }
            
            if (!hasCheeze) {
                System.out.println(time);
                break;
            }
            time++;
        }

    }

    private static void externalAir(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offerLast(new int[]{0, 0});
        if (maps[0][0] == 0) maps[0][0] = 2;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (visited[ny][nx] || maps[ny][nx] == 1) continue;
                visited[ny][nx] = true;
                maps[ny][nx] = 2;
                q.offerLast(new int[]{nx, ny});
            }
        }
    }

    private static boolean isMeltCheeze(int[][] maps, int x, int y) {
        int N = maps.length;
        int M = maps[0].length;
        int exposeCnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (maps[ny][nx] == 2) exposeCnt++;
        }
        return exposeCnt >= 2;
    }
}
