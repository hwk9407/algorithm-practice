import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<long[]> queue = new ArrayDeque<>();
        queue.offerLast(new long[]{a, 1});
        while (!queue.isEmpty()) {
            long[] current = queue.pollFirst();
            if (current[0] == b) {
                System.out.println(current[1]);
                return;
            }
            if (current[0] > b) continue;
            current[1]++;
            queue.offerLast(new long[]{current[0] * 2, current[1]});
            queue.offerLast(new long[]{current[0] * 10 + 1, current[1]});
        }
        System.out.println(-1);
    }
}