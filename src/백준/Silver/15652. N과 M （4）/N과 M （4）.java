import java.util.*;
import java.io.*;

public class Main {
    private static class State {
        int depth;
        int next;

        State(int depth, int next) {
            this.depth = depth;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pick = new int[M];
        Deque<State> stack = new ArrayDeque<>();
        stack.offerLast(new State(0, 1));
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            State current = stack.peekLast();

            if (current.depth == M) {
                for (int x : pick) sb.append(x).append(' ');
                sb.setLength(sb.length() - 1);
                sb.append('\n');

                stack.pollLast();
                if (!stack.isEmpty()) stack.peekLast().next++;
                continue;
            }

            if (current.next > N) {
                stack.pollLast();
                if (!stack.isEmpty()) stack.peekLast().next++;
                continue;
            }

            pick[current.depth] = current.next;
            stack.offerLast(new State(current.depth + 1, current.next));
        }
        System.out.print(sb);
    }
}