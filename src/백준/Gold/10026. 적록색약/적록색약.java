import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] maps = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            maps[i] = line.toCharArray();
        }

        boolean[][] visitedRedGreen = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        int redGreenCount = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedRedGreen[i][j]) {
                    bfs(maps, visitedRedGreen, j, i, n, true);
                    redGreenCount++;
                }
                if (!visited[i][j]) {
                    bfs(maps, visited, j, i, n, false);
                    count++;
                }
            }
        }
        System.out.println(count + " " + redGreenCount);
    }
    private static void bfs(char[][] maps, boolean[][] visited, int x, int y, int n, boolean redGreenFlag) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            char currentChar = maps[current[1]][current[0]];
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[ny][nx]) continue;
                if (redGreenFlag) {
                    if((currentChar == 'R' || currentChar == 'G') && (maps[ny][nx] == 'R' || maps[ny][nx] == 'G')) {
                        visited[ny][nx] = true;
                        queue.addLast(new int[]{nx, ny});
                        continue;
                    }
                }
                if (currentChar == maps[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }
    }
}