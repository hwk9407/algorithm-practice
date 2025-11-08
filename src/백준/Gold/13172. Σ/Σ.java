import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[][] arr = new int[M][2];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            arr[i][0] = N;
            arr[i][1] = S;
        }

        final int MOD = 1_000_000_007;
        long result = 0;

        for (int i = 0; i < M; i++) {
            long N = arr[i][0];
            long S = arr[i][1];
            long inv = pow(N, MOD - 2, MOD);
            result = (result + S * inv) % MOD;
        }

        System.out.println(result);
    }

    private static long pow(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}