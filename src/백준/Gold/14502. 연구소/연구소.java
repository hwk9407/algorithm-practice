import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = buildWall(maps, N, M, 0);
        System.out.println(answer);
    }
    private static int buildWall(int[][] maps, int N, int M, int cnt) {
        if (cnt == 3) {
            int[][] copied = copyMap(maps, N, M);
            infect(copied, N, M);
            return countZero(copied, N, M);
        }

        int maxSafe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 1;
                    maxSafe = Math.max(maxSafe, buildWall(maps, N, M, cnt + 1));
                    maps[i][j] = 0;
                }
            }
        }
        return maxSafe;
    }

    private static void infect(int[][] maps, int N, int M) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 2) q.offer(new int[]{j, i});
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + current[0];
                int ny = dy[d] + current[1];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (maps[ny][nx] != 0) continue;
                maps[ny][nx] = 2;
                q.offerLast(new int[]{nx, ny});
            }
        }
    }

    private static int countZero(int[][] maps, int N, int M) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    private static int[][] copyMap(int[][] origin, int N, int M) {
        int[][] copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(origin[i], 0, copied[i], 0, M);
        }
        return copied;
    }
}
