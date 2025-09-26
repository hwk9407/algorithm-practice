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

        int[] path = new int[M];
        StringBuilder sb = new StringBuilder();
        Deque<State> stack = new ArrayDeque<>();
        stack.offerLast(new State(0, 1));

        while (!stack.isEmpty()) {
            State f = stack.peekLast();

            if (f.depth == M) {
                for (int x : path) sb.append(x).append(' ');
                sb.append('\n');

                stack.pollLast();
                if (!stack.isEmpty()) stack.peekLast().next++;
                continue;
            }

            int maxStart = N - (M - f.depth) + 1;
            if (f.next > maxStart) {
                stack.pollLast();
                if (!stack.isEmpty()) stack.peekLast().next++;
                continue;
            }

            path[f.depth] = f.next;
            stack.offerLast(new State(f.depth + 1, f.next + 1));
        }

        System.out.print(sb);
    }
}
