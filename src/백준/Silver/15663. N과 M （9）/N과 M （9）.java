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

        boolean[] visited = new boolean[n];
        int[] path = new int[m];
        StringBuilder sb = new StringBuilder();
        dfs(arr, visited, path, sb, m, 0);
        
        System.out.print(sb);
    }

    private static void dfs(int[] arr, boolean[] visited, int[] path, StringBuilder sb, int m, int depth) {
        if (depth == m) {
            for (int x : path) sb.append(x).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            path[depth] = arr[i];
            dfs(arr, visited, path, sb, m, depth + 1);
            visited[i] = false;
        }
    }
}