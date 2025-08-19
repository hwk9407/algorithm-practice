import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            line = br.readLine().split(" ");
            Deque<int[]> queue = new ArrayDeque<>();
            Integer[] arr = new Integer[n];
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(line[j]);
                queue.offerLast(new int[]{j, val});
                arr[j] = val;
            }
            Arrays.sort(arr, Comparator.reverseOrder());

            int order = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.pollFirst();
                if (current[1] != arr[order]) {
                    queue.offerLast(current);
                    continue;
                }
                order++;
                if (current[0] == m) break;
            }
            System.out.println(order);
        }
    }
}