import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pollLast();
                continue;
            }
            stack.offerLast(num);
        }
        int sum = stack.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }
}