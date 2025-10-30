import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        int result = dfs(col, diag1, diag2, n, 0);
        System.out.println(result);
    }

    private static int dfs(boolean[] col, boolean[] diag1, boolean[] diag2, int n, int row) {
        if (row == n) return 1;

        int count = 0;
        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + n - 1]) continue;

            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + n - 1] = true;

            count += dfs(col, diag1, diag2, n, row + 1);

            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + n - 1] = false;
        }

        return count;
    }
}
