import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int acc = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                acc += Integer.parseInt(st.nextToken());
                arr[i][j] = acc;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int j = y1; j <= y2; j++) {
                sum += arr[j][x2] - beforeValue(arr, x1, j);
            }
            System.out.println(sum);
        }

    }

    private static int beforeValue(int[][] arr, int x, int y) {
        x--;
        if (x < 0) {
            x = arr[0].length - 1;
            y--;
            if (y < 0) return 0;
        }
        return arr[y][x];
    }
}