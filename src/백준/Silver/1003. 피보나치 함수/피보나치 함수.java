import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int max = 2;
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            max = Math.max(max, n);
        }
        int[][] fiboCnt = new int[max + 1][2];
        fiboCnt[0][0] = 1;
        fiboCnt[0][1] = 0;
        fiboCnt[1][0] = 0;
        fiboCnt[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            fiboCnt[i][0] = fiboCnt[i - 2][0] + fiboCnt[i - 1][0];
            fiboCnt[i][1] = fiboCnt[i - 2][1] + fiboCnt[i - 1][1];
        }
        for (int num : arr) {
            System.out.println(fiboCnt[num][0] + " " + fiboCnt[num][1]);
        }
    }
}