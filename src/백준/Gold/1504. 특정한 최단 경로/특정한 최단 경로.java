import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    private static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Node {
        int vertex;
        int dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(graph, N, 1);
        int[] distV1 = dijkstra(graph, N, v1);
        int[] distV2 = dijkstra(graph, N, v2);

        long path1 = (long) dist1[v1] + distV1[v2] + distV2[N];
        long path2 = (long) dist1[v2] + distV2[v1] + distV1[N];
        long result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }

    private static int[] dijkstra(List<List<Edge>> graph, int N, int start) {
        int[] dist = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

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
