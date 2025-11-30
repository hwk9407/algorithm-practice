import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, cost});
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1]; // 역추적 배열
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[a] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        pq.offer(new int[]{a, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (current[1] > dist[current[0]]) continue;
            if (current[0] == b) {
                System.out.println(current[1]);
                int cnt = 1;
                int path = b;
                StringBuilder sb = new StringBuilder();
                sb.append(path);
                while (path != a) {
                    path = parent[path];
                    sb.insert(0, path + " ");
                    cnt++;
                }
                System.out.println(cnt);
                System.out.println(sb);
                break;
            }
            for (int[] next : graph.get(current[0])) {
                if (dist[next[0]] > next[1] + current[1]) {
                    dist[next[0]] = next[1] + current[1];
                    parent[next[0]] = current[0];
                    pq.offer(new int[]{next[0], next[1] + current[1]});
                }
            }
        }
    }
}
