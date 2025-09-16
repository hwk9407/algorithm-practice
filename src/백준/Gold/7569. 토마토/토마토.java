import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[h][n][m];
        boolean[][][] visited = new boolean[h][n][m];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.offer(new int[]{k, j, i, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        int maxMove = 0;
        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dy = {1, 0, -1, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            maxMove = Math.max(maxMove, current[3]);
            for (int d = 0; d < 6; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                int nz = current[2] + dz[d];
                int move = current[3] + 1;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) continue;
                if (visited[nz][ny][nx]) continue;
                if (box[nz][ny][nx] == -1) continue;
                visited[nz][ny][nx] = true;
                box[nz][ny][nx] = 1;
                q.offerLast(new int[]{nx, ny, nz, move});
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        maxMove = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(maxMove);
    }
}