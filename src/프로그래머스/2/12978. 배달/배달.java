import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int cost = r[2];
            
            graph.get(start).add(new int[]{end, cost});
            graph.get(end).add(new int[]{start, cost});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]); // cost 기준으로 오름차순
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int start = current[0];
            int cost = current[1];
            
            if (cost > dist[start]) continue;
            for (int[] next : graph.get(start)) {
                int end = next[0];
                int nextCost = next[1] + cost;
                if (nextCost < dist[end]) {
                    dist[end] = nextCost;
                    q.offer(new int[]{end, nextCost});
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
} 