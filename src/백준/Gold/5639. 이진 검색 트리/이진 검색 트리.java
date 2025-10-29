import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        Node root = new Node(Integer.parseInt(line));
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerLast(root);

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            Node before = stack.peekLast();
            int value = Integer.parseInt(line);
            Node newNode = new Node(value);
            if (before.num > value) {
                before.left = newNode;
                stack.offerLast(newNode);
            } else {
                while (!stack.isEmpty() && stack.peekLast().num < value) {
                    before = stack.pollLast();
                }
                before.right = newNode;
                stack.offerLast(newNode);
            }
        }

        stack.clear();
        stack.offerLast(root);
        Set<Node> prev = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node current = stack.peekLast();
            if ((current.left == null || prev.contains(current.left)) && (current.right == null || prev.contains(current.right))) {
                stack.pollLast();
                prev.add(current);
                sb.append(current.num).append('\n');
                continue;
            }

            if (current.left != null && !prev.contains(current.left)) {
                stack.offerLast(current.left);
                continue;
            }
            if (current.right != null && !prev.contains(current.right)) {
                stack.offerLast(current.right);
            }
        }
        System.out.print(sb);
    }
}