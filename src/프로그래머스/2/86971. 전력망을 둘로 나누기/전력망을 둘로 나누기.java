import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int size = dfs(graph, n, v1);
            int diff = Math.abs(2 * size - n);
            answer = Math.min(answer, diff);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    private int dfs(List<Integer>[] graph, int n, int node) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        stack.push(node);
        visited[node] = true;
        
        while(!stack.isEmpty()) {
            count++;
            int current = stack.pop();
            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
        
        return count;
    }
}