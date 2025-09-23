import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        int x, y;
        int sum;
        int depth;
        int dir;

        Node(int x, int y, int sum, int depth, int dir) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.depth = depth;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int max = 0;
        int sum;
        boolean[][] visited = new boolean[n][m];
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // dfs
                visited[i][j] = true;
                sum = paper[i][j];
                stack.offerLast(new Node(j, i, sum, 1, 0));
                while (!stack.isEmpty()) {
                    Node current = stack.peekLast();

                    if (current.depth == 4) {
                        max = Math.max(max, current.sum);
                        visited[current.y][current.x] = false;
                        stack.pollLast();
                        continue;
                    }

                    if (current.dir == 4) {
                        visited[current.y][current.x] = false;
                        stack.pollLast();
                        continue;
                    }

                    int k = current.dir++;
                    int nx = current.x + dx[k];
                    int ny = current.y + dy[k];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    stack.offerLast(new Node(nx, ny, current.sum + paper[ny][nx], current.depth + 1, 0));
                }

                // ㅓ ㅏ ㅗ ㅜ 예외 로직
                int cnt = 0;
                sum = paper[i][j];
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    cnt++;
                    min = Math.min(min, paper[ny][nx]);
                    sum += paper[ny][nx];
                }
                if (cnt < 3) continue;
                else if (cnt == 4) sum -= min;
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}