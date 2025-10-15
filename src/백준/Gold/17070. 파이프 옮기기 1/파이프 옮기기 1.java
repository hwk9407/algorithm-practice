import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                 maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][n][3]; // 0: 가로, 1: 세로, 2: 대각선
        dp[0][1][0] = 1;

        for (int y = 0; y < n; y++) {
            for (int x = 2; x < n; x++) {
                if (maps[y][x] == 1) continue;

                if (maps[y][x - 1] == 0)
                    dp[y][x][0] = dp[y][x - 1][0] + dp[y][x - 1][2];
                if (y - 1 >= 0 && maps[y - 1][x] == 0)
                    dp[y][x][1] = dp[y - 1][x][1] + dp[y - 1][x][2];
                if (y - 1 >= 0 && maps[y][x - 1] == 0 && maps[y - 1][x] == 0 && maps[y - 1][x - 1] == 0)
                    dp[y][x][2] = dp[y - 1][x - 1][0] + dp[y - 1][x - 1][1] + dp[y - 1][x - 1][2];
            }
        }
        int result = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
        System.out.println(result);
    }
}