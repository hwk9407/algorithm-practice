import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, t});
            reverseGraph.get(end).add(new int[]{start, t});
        }

        int result = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distToX = new int[n + 1];
        Arrays.fill(distToX, -1);
        pq.offer(new int[]{x, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (distToX[current[0]] != -1) continue;
            distToX[current[0]] = current[1];
            for (int[] next : reverseGraph.get(current[0])) {
                if (distToX[next[0]] != -1) continue;
                pq.offer(new int[]{next[0], current[1] + next[1]});
            }
        }
        int[] distFromX = new int[n + 1];
        Arrays.fill(distFromX, -1);
        pq.offer(new int[]{x, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (distFromX[current[0]] != -1) continue;
            distFromX[current[0]] = current[1];
            for (int[] next : graph.get(current[0])) {
                if (distFromX[next[0]] != -1) continue;
                pq.offer(new int[]{next[0], current[1] + next[1]});
            }
        }

        distFromX[x] = 0;
        distToX[x] = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, distFromX[i] + distToX[i]);
        }

        System.out.println(result);
    }
}
