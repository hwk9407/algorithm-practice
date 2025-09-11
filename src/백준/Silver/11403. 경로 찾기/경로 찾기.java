import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] reach = new int[n][n];

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Deque<Integer> stack = new ArrayDeque<>();
            stack.offerLast(i);

            while (!stack.isEmpty()) {
                int current = stack.pollLast();
                for (int next = 0; next < n; next++) {
                    if (graph[current][next] == 0 || visited[next]) continue;
                    visited[next] = true;
                    reach[i][next] = 1;
                    stack.offerLast(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(reach[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}