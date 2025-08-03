import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long[] factorial = getFactorial(n);
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        k -= 1;
        for (int i = 0; i < n; i++) {
            long f = factorial[n - 1 - i];
            int idx = (int) (k / f);
            answer[i] = list.get(idx);
            list.remove(idx);
            k = k % f;
        }
        return answer;
    }
    
    private long[] getFactorial(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        return dp;
    }
}