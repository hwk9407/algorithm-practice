import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            stack.offerLast(i);
            visited[i] = true;
            cnt++;
            
            while (!stack.isEmpty()) {
                int current = stack.pollLast();
                
                for (int j = 0; j < n; j++) {
                    if (computers[current][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        stack.offerLast(j);
                    }
                }
            }
        }
        
        return cnt;
    }
}