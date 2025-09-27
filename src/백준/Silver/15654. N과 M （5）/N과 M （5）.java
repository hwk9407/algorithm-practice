import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static boolean[] used;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] pick = new int[m];
        used = new boolean[n];
        sb = new StringBuilder();
        dfs(arr, pick, 0);

        System.out.print(sb);
    }

    private static void dfs(int[] arr, int[] pick, int depth) {
        if (depth == m) {
            for (int x : pick) sb.append(x).append(' ');
            sb.setLength(sb.length() - 1);
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            pick[depth] = arr[i];
            dfs(arr, pick, depth + 1);
            used[i] = false;
        }
    }
}