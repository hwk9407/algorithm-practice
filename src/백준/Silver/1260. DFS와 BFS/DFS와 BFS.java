import java.util.*;
import java.io.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int v = Integer.parseInt(line[2]);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (List<Integer> list : graph) {
            list.sort(Comparator.naturalOrder());
        }
        dfs(v, n);
        bfs(v, n);
    }

    private static void dfs(int startNode, int n) {
        StringBuilder sb = new StringBuilder();
        boolean[] isVisited = new boolean[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(startNode);
        while (!stack.isEmpty()) {
            int node = stack.pollLast();

            if (isVisited[node]) continue;
            isVisited[node] = true;
            sb.append(node).append(" ");

            List<Integer> nextGraph = graph.get(node);
            for (int i = nextGraph.size() - 1; i >= 0; i--) {
                int next = nextGraph.get(i);
                if (!isVisited[next]) stack.offerLast(next);
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
    private static void bfs(int startNode, int n) {
        StringBuilder sb = new StringBuilder();
        boolean[] isVisited = new boolean[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(startNode);
        isVisited[startNode] = true;
        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            sb.append(node).append(" ");
            for (int next : graph.get(node)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.offerLast(next);
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}