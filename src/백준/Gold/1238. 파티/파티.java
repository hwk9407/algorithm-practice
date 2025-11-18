import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, t});
            reverseGraph.get(end).add(new int[]{start, t});
        }

        int[] distToX = dijkstra(reverseGraph, x, n);
        int[] distFromX = dijkstra(graph, x, n);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, distFromX[i] + distToX[i]);
        }


        System.out.println(result);
    }

    private static int[] dijkstra(List<List<int[]>> graph, int x, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        pq.offer(new int[]{x, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (result[current[0]] != -1) continue;
            result[current[0]] = current[1];
            for (int[] next : graph.get(current[0])) {
                if (result[next[0]] != -1) continue;
                pq.offer(new int[]{next[0], current[1] + next[1]});
            }
        }
        return result;
    }
}
