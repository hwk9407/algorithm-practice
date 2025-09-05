import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }
        boolean[][] visited = new boolean[n][n];
        int total = 0;
        List<Integer> size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || maps[i][j] == 0) continue;
                total++;
                size.add(bfs(maps, visited, n, j, i));
            }
        }
        size.sort(Comparator.naturalOrder());
        System.out.println(total);
        for (int s : size) {
            System.out.println(s);
        }
    }

    private static int bfs(int[][] maps, boolean[][] visited, int n, int startX, int startY) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[startY][startX] = true;
        queue.offerLast(new int[]{startX, startY});
        int result = 1;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while(!queue.isEmpty()) {
            int[] current = queue.pollFirst();

            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[ny][nx] || maps[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                result++;
                queue.offerLast(new int[]{nx, ny});
            }
        }
        return result;
    }
}
