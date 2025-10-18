import java.util.*;
import java.io.*;

public class Main {
    private static int INF = Integer.MAX_VALUE;

    private static class Edge {
        int to;
        int cost;

        public Edge (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Node {
        int vertex;
        int dist;

        public Node (int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = dijkstra(graph, V, K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
        System.out.print(sb);
    }

    private static int[] dijkstra(List<List<Edge>> graph, int V, int K) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.offer(new Node(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Edge next : graph.get(current.vertex)) {
                if (dist[next.to] <= current.dist + next.cost) continue;
                dist[next.to] = current.dist + next.cost;
                pq.offer(new Node(next.to, dist[next.to]));
            }
        }

        return dist;
    }
}