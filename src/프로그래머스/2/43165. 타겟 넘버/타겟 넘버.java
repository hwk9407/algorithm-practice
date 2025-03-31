import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    
    private int dfs(int[] numbers, int idx, int sum, int target) {
        // idx가 5인데 target과 sum이 같으면 1 반환 아니면 0반환 후 리턴
        if (idx == numbers.length) {
            return (sum == target) ? 1 : 0;
        }
        
        int plus = dfs(numbers, idx + 1, sum + numbers[idx], target);
        int minus = dfs(numbers, idx + 1, sum - numbers[idx], target);
        
        return plus + minus;
    }
}