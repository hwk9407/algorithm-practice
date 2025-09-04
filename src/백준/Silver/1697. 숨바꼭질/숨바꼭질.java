import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] distance = new int[100001];
        boolean[] isVisited = new boolean[100001];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(n);

        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            if (current == k) {
                System.out.println(distance[current]);
                break;
            }
            int[] nextArr = new int[]{current - 1, current + 1, current * 2};
            for (int next : nextArr) {
                if (next < 0 || next > 100000 || isVisited[next]) continue;
                isVisited[next] = true;
                distance[next] = distance[current] + 1;
                queue.offerLast(next);
            }
        }
    }
}