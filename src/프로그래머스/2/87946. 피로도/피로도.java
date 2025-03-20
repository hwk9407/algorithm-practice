import java.util.Stack;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = dfs(k, 0, dungeons, new boolean[dungeons.length]);
        
        return answer;
    }
    
    private int dfs(int k, int count, int[][] dungeons, boolean[] visited) {
        int maxCount = count;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                maxCount = Math.max(maxCount, dfs(k - dungeons[i][1], count + 1, dungeons, visited));
                visited[i] = false;
            }
        }
        return maxCount;
    }
}