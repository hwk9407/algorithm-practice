import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        char ch;
        int state;

        Node(char ch, int state) {
            this.ch = ch;
            this.state = state;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, char[]> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            graph.put(parent, new char[]{left, right});
        }

        Deque<Character> stack = new ArrayDeque<>();
        stack.offerLast('A');

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character current = stack.pollLast();
            sb.append(current);

            for (int i = 1; i >= 0; i--) {
                char ch = graph.get(current)[i];
                if (ch == '.') continue;
                stack.offerLast(ch);
            }
        }
        sb.append('\n');

        Deque<Node> stack2 = new ArrayDeque<>();
        stack2.offerLast(new Node('A', 0));
        while (!stack2.isEmpty()) {
            Node current = stack2.pollLast();

            if (current.ch == '.') continue;

            if (current.state == 0) {
                stack2.offerLast(new Node(graph.get(current.ch)[1], 0));
                stack2.offerLast(new Node(current.ch, 1));
                stack2.offerLast(new Node(graph.get(current.ch)[0], 0));
            } else {
                sb.append(current.ch);
            }
        }
        sb.append('\n');

        stack2.offerLast(new Node('A', 0));
        while (!stack2.isEmpty()) {
            Node current = stack2.pollLast();

            if (current.ch == '.') continue;
            if (current.state == 0) {
                stack2.offerLast(new Node(current.ch, 1));
                stack2.offerLast(new Node(graph.get(current.ch)[1], 0));
                stack2.offerLast(new Node(graph.get(current.ch)[0], 0));
            } else {
                sb.append(current.ch);
            }
        }
        System.out.println(sb);
    }
}