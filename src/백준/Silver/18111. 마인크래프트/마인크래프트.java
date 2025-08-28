import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int b = Integer.parseInt(st.nextToken()); // 갖고있던거

        int[][] maps = new int[n][m];
        int min = 256;
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, maps[i][j]);
                max = Math.max(max, maps[i][j]);
            }
        }

        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        for (int target = min; target <= max; target++) {
            int useBlock = 0;
            int time = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (maps[j][k] == target) continue;
                    int diff = target - maps[j][k];
                    useBlock += diff;
                    if (diff < 0) time += 2 * Math.abs(diff);
                    else time += Math.abs(diff);
                }
            }
            if (useBlock > b) continue;
            if (result[0] >= time) {
                result[0] = time;
                result[1] = target;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}