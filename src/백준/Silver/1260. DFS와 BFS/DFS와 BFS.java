import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i <= n; i++) graph.get(i).sort(Comparator.naturalOrder());
        dfs(v);
        System.out.println(sb.toString());
        
        sb.setLength(0);
        Arrays.fill(visited, false);
        
        bfs(v);
        System.out.println(sb.toString());
    };
    
    public static void dfs(int node) {
        visited[node] = true;
        if (sb.length() != 0) sb.append(" ");
        sb.append(node);
        for (int next : graph.get(node)) {
            if (!visited[next]) dfs(next);
        }
    }
    
    public static void bfs(int node) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.pollFirst();
            if (sb.length() != 0) sb.append(" ");
            sb.append(current);
            
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offerLast(next);
                    visited[next] = true;
                }
            }
        }
    }
}