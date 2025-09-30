import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            int current = stack.pollLast();

            for (Integer next : graph.get(current)) {
                if (visited[next]) continue;
                visited[next] = true;
                parent[next] = current;
                stack.offerLast(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }
}