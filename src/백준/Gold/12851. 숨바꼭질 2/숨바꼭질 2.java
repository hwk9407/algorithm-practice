import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0;
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<int[]> q = new ArrayDeque<>();
        int[] visited = new int[100001];
        q.offerLast(new int[]{N, 0});
        Arrays.fill(visited, -1);
        visited[N] = 0;

        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            if (minTime < current[1]) continue;
            if (current[0] == K) {
                cnt++;
                minTime = current[1];
            }

            int[] nextPos = new int[]{current[0] + 1, current[0] - 1, current[0] * 2};
            for (int next : nextPos) {
                if (next > 100000 || next < 0) continue;
                if (visited[next] != -1 && visited[next] != current[1] + 1) continue;
                visited[next] = current[1] + 1;
                q.offerLast(new int[]{next, current[1] + 1});
            }
        }
        System.out.println(minTime);
        System.out.println(cnt);
    }
}
