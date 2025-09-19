import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        n += Integer.parseInt(st.nextToken());
        int[] maps = new int[101];
        for (int i = 1; i <= 100; i++) {
            maps[i] = i;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            maps[start] = end;
        }

        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        q.offerLast(new int[]{1, 0});
        visited[1] = true;
        int result = 0;
        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            if (current[0] == 100) {
                result = current[1];
                break;
            }
            for (int dice = 1; dice <= 6; dice++) {
                if (current[0] + dice > 100) continue;
                int next = maps[current[0] + dice];
                if (visited[next]) continue;
                visited[next] = true;
                q.offerLast(new int[]{next, current[1] + 1});
            }
        }
        System.out.println(result);
    }
}