import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
        }

        int[][] answer = matrixPower(matrix, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(answer[i][j]).append(' ');
            sb.setLength(sb.length() - 1);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static int[][] matrixPower(int[][] a, long b) {
        if (b == 1) return a;
        int[][] half = matrixPower(a, b / 2);
        int[][] result = matrixMultiply(half, half);
        if (b % 2 == 1) result = matrixMultiply(result, a);

        return result;
    }

    private static int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) sum += a[i][k] * b[k][j];
                result[i][j] = sum % 1000;
            }
        }
        return result;
    }
}