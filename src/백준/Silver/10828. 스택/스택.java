import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String command = line[0];
            if (command.equals("push")) {
                int x = Integer.parseInt(line[1]);
                stack.offerLast(x);
            } else if (command.equals("pop")) {
                Integer x = stack.pollLast();
                x = x == null ? -1 : x;
                System.out.println(x);
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else if (command.equals("top")) {
                Integer x = stack.peekLast();
                x = x == null ? -1 : x;
                System.out.println(x);
            }
        }
    }
}