import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int[][] maps = new int[n][m];
        int[] start = new int[2];

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 2) {
                    start[0] = j;
                    start[1] = i;
                    maps[i][j] = 1;
                } else if (maps[i][j] == 0) distance[i][j] = 0;
            }
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> queue = new ArrayDeque<>();
        visited[start[1]][start[0]] = true;
        queue.offerLast(new int[]{start[0], start[1], 0});
        distance[start[1]][start[0]] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visited[ny][nx]) continue;
                if (maps[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                int nextDistance = current[2] + 1;
                distance[ny][nx] = nextDistance;
                queue.offerLast(new int[]{nx, ny, nextDistance});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distance[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}