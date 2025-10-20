import java.util.*;
import java.io.*;

public class Main {

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
        int n = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int[] maxNode1 = dfs(graph, n, 1);
        int[] maxNode2 = dfs(graph, n, maxNode1[0]);
        System.out.println(maxNode2[1]);
    }

    private static int[] dfs(List<List<Edge>> graph, int n, int start) {
        Deque<Node> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        stack.offerLast(new Node(start, 0));
        int max = 0;
        int maxNode = 0;
        while (!stack.isEmpty()) {
            Node current = stack.pollLast();
            for (Edge next : graph.get(current.vertex)) {
                int nextCost = next.cost + current.dist;
                if (visited[next.to]) continue;
                visited[next.to] = true;
                if (nextCost > max) {
                    max = nextCost;
                    maxNode = next.to;
                }
                stack.offerLast(new Node(next.to, nextCost));
            }
        }
        return new int[]{maxNode, max};
    }
}