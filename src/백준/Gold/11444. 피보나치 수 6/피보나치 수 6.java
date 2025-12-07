import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n <= 1) {
            System.out.println(n);
            return;
        }
        long[][] answer = power(new long[][]{{1, 1}, {1, 0}}, n - 1);
        System.out.println(answer[0][0]);
    }

    private static long[][] power(long[][] matrix, long n) {
        if (n == 1) return matrix;

        long[][] half = power(matrix, n / 2);
        long[][] result = multiple(half, half);
        if (n % 2 == 1) result = multiple(result, matrix);
        return result;
    }

    private static long[][] multiple(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 1000000007;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 1000000007;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 1000000007;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 1000000007;
        return result;
    }
}
