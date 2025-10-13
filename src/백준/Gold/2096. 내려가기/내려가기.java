import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] score = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] max = new int[n + 1][3];
        int[][] min = new int[n + 1][3];
        max[1][0] = score[1][0];
        max[1][1] = score[1][1];
        max[1][2] = score[1][2];
        min[1][0] = score[1][0];
        min[1][1] = score[1][1];
        min[1][2] = score[1][2];

        for (int i = 2; i <= n; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + score[i][0];
            max[i][1] = Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + score[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + score[i][2];

            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + score[i][0];
            min[i][1] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + score[i][1];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + score[i][2];
        }
        String result = Math.max(Math.max(max[n][0], max[n][1]), max[n][2]) + " " + Math.min(Math.min(min[n][0], min[n][1]), min[n][2]);
        System.out.println(result);
    }
}