import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                int num = queue.isEmpty() ? 0 : queue.poll();
                sb.append(num).append("\n");
                continue;
            }
            queue.add(x);
        }
        System.out.print(sb);
    }
}