import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            boolean isVps = true;
            Deque<Character> stack = new ArrayDeque<>();
            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    stack.offerLast(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.peekLast() != '(') {
                        isVps = false;
                        break;
                    }
                    stack.pollLast();
                } else {
                    isVps = false;
                    break;
                }
            }
            if (!stack.isEmpty()) isVps = false;

            System.out.println(isVps ? "YES" : "NO");
        }
    }
}