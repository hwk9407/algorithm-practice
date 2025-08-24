import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로 길이
            int n = Integer.parseInt(st.nextToken()); // 세로 길이
            int k = Integer.parseInt(st.nextToken()); // 심어진 배추 개수

            int[][] maps = new int[n][m];
            boolean[][] isVisited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                maps[y][x] = 1;
            }

            int count = 0;
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < m; row++) {
                    if (isVisited[col][row] || maps[col][row] == 0) continue;
                    isVisited[col][row] = true;
                    count++;
                    dfs(maps, isVisited, row, col);
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int[][] maps, boolean[][] isVisited, int startX, int startY) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(new int[]{startX, startY});
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while (!stack.isEmpty()) {
            int[] current = stack.pollLast();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length) continue;
                if (isVisited[ny][nx] || maps[ny][nx] == 0) continue;
                isVisited[ny][nx] = true;
                stack.offerLast(new int[]{nx, ny});
            }
        }
    }
}