import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) return;
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            for (char ch : line.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.offerLast(ch);
                } else if (ch == ')') {
                    Character lastChar = stack.peekLast();
                    if (lastChar == null || lastChar != '(') {
                        isValid = false;
                        break;
                    } else stack.pollLast();
                } else if (ch == ']') {
                    Character lastChar = stack.peekLast();
                    if (lastChar == null || lastChar != '[') {
                        isValid = false;
                        break;
                    } else stack.pollLast();
                }
            }
            System.out.println((stack.isEmpty() && isValid) ? "yes" : "no");
        }
    }
}