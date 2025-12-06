import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                graph.get(start).add(new int[]{end, dist});
            }
        }
        int[] result = dfs(graph, V, 1);
        result = dfs(graph, V, result[0]);
        System.out.println(result[1]);
    }

    private static int[] dfs(List<List<int[]>> graph, int V, int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(new int[]{start, 0});
        while (!stack.isEmpty()) {
            int[] current = stack.pollLast();

            for (int[] next : graph.get(current[0])) {
                int distance = current[1] + next[1];
                if (distance >= dist[next[0]]) continue;
                dist[next[0]] = distance;
                stack.offerLast(new int[]{next[0], distance});
            }
        }
        int[] result = new int[2];
        for (int i = 1; i <= V; i++) {
            if (dist[i] != Integer.MAX_VALUE && dist[i] > result[1]) {
                result[1] = dist[i];
                result[0] = i;
            }
        }

        return result;
    }
}
