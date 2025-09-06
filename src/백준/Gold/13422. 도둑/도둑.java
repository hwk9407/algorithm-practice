import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                queue.offerLast(arr[j]);
                sum += arr[j];
            }
            int count = 0;
            if (n == m) {
                System.out.println(sum < k ? 1 : 0);
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (sum < k) count++;
                sum -= queue.pollFirst();
                int idx = (j + m) % n;
                queue.offerLast(arr[idx]);
                sum += arr[idx];
            }
            System.out.println(count);
        }
    }
}