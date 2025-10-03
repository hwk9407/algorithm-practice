import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int[] path = new int[m];
        StringBuilder sb = new StringBuilder();
        dfs(arr, path, m, 0, 0, sb);
        System.out.print(sb);
    }

    private static void dfs(int[] arr, int[] path, int m, int depth, int startIdx, StringBuilder sb) {
        if (depth == m) {
            for (int x : path) sb.append(x).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = startIdx; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) continue;
            path[depth] = arr[i];
            dfs(arr, path, m, depth + 1, i, sb);
        }
    }
}