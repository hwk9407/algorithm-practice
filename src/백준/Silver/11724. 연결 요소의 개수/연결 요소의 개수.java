import java.util.*;
import java.io.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        // 정점의 개수
        int n = Integer.parseInt(line[0]);
        // 간선의 개수
        int m = Integer.parseInt(line[1]);
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] isVisited = new boolean[n + 1];
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

        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            count++;
            stack.offerLast(i);
            while (!stack.isEmpty()) {
                int node = stack.pollLast();
                List<Integer> neighbor = graph.get(node);
                for (int next : neighbor) {
                    if (isVisited[next]) continue;
                    isVisited[next] = true;
                    stack.offerLast(next);
                }
            }
        }
        System.out.println(count);
    }
}
