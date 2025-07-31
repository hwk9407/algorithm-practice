import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int cnt = 0;
        int current = x;
        dp[current] = cnt;
        while (current > 1) {
            cnt = dp[current] + 1;
            if (current % 3 == 0) dp[current / 3] = Math.min(cnt, dp[current / 3]);
            if (current % 2 == 0) dp[current / 2] = Math.min(cnt, dp[current / 2]);
            dp[current - 1] = Math.min(cnt, dp[current - 1]);
            current--;
        }
        System.out.println(dp[1]);
    }
}