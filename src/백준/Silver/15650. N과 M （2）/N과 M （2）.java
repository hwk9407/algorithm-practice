import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        dfs(0, 1, new int[M]);
        System.out.print(sb);
    }

    private static void dfs(int depth, int start, int[] arr) {
        if (depth == M) {
            for (int x : arr) sb.append(x).append(' ');
            sb.setLength(sb.length() - 1);
            sb.append('\n');
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1, arr);
        }
    }
}