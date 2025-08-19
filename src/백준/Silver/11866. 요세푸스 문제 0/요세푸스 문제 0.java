import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offerLast(i);
        }

        int[] arr = new int[n];
        int idx = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offerLast(queue.pollFirst());
            }

            if (queue.peekFirst() == null) break;
            arr[idx++] = queue.pollFirst();
        }
        StringBuilder sb = new StringBuilder("<");
        for (int num : arr) {
            sb.append(num).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }
}