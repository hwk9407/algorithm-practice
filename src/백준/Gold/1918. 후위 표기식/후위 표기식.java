import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : expr.toCharArray()) {
            if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '(' && ch != ')') {
                sb.append(ch);
                continue;
            }
            if (ch == '(') {
                stack.offerLast(ch);
                continue;
            }
            if (ch == ')') {
                while (true) {
                    char tmp = stack.pollLast();
                    if (tmp == '(') break;
                    sb.append(tmp);
                }
                continue;
            }
            while (!stack.isEmpty() && priority(stack.peekLast()) >= priority(ch)) { // 기존 >= 새로넣을 우선순위
                sb.append(stack.pollLast());
            }
            stack.offerLast(ch);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        System.out.println(sb);
    }

    static int priority(char operation) {
        if (operation == '(') return 1;
        if (operation == '+' || operation == '-') return 2;
        if (operation == '*' || operation == '/') return 3;
        return -1;
    }
}
