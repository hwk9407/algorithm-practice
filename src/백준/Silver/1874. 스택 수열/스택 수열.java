import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stack.offerLast(i);
            sb.append("+").append("\n");
            while (!stack.isEmpty() && stack.peekLast() == arr[idx]) {
                stack.pollLast();
                idx++;
                sb.append("-").append("\n");
                if (idx == n) break;
            }
        }
        String result = !stack.isEmpty() ? "NO" : sb.toString();
        System.out.print(result);
    }
}