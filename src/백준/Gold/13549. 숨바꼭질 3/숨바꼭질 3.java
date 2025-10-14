import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (current[0] == k) {
                System.out.println(current[1]);
                break;
            }
            if (current[1] > dist[current[0]]) continue;

            int next = current[0] * 2;
            if (next <= 100000 && dist[next] > current[1]) {
                dist[next] = current[1];
                pq.offer(new int[]{next, current[1]});
            }
            next = current[0] - 1;
            if (next >= 0 && dist[next] > current[1] + 1) {
                dist[next] = current[1] + 1;
                pq.offer(new int[]{next, current[1] + 1});
            }

            next = current[0] + 1;
            if (next <= 100000 && dist[next] > current[1] + 1) {
                dist[next] = current[1] + 1;
                pq.offer(new int[]{next, current[1] + 1});
            }
        }
    }
}