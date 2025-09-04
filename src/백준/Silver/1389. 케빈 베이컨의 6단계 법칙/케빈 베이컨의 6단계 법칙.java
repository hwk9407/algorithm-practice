import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int minSum = Integer.MAX_VALUE;
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            int sum = bfs(graph, i, n);
            if (minSum > sum) {
                minSum = sum;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static int bfs(List<List<Integer>> graph, int start, int n) {
        boolean[] isVisited = new boolean[n + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{start, 0});
        isVisited[start] = true;

        int sum = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            sum += current[1];
            for (int next : graph.get(current[0])) {
                if (isVisited[next]) continue;
                isVisited[next] = true;
                queue.offerLast(new int[]{next, current[1] + 1});

            }
        }
        return sum;
    }
}