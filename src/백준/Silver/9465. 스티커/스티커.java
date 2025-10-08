import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 1][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n + 1][2];
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                int max = Math.max(dp[j - 2][0], dp[j - 2][1]);
                dp[j][0] = max + arr[j][0];
                dp[j][1] = max + arr[j][1];

                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + arr[j][0]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] + arr[j][1]);
            }
            System.out.println(Math.max(dp[n][0], dp[n][1]));
        }
    }
}