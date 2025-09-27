import java.util.*;
import java.io.*;

public class Main {
    private static class Frame {
        int depth;
        int nextIdx;
        int chosen;

        Frame(int depth, int nextIdx) {
            this.depth = depth;
            this.nextIdx = nextIdx;
            this.chosen = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int[] pick = new int[m];
        boolean[] used = new boolean[n];
        StringBuilder sb = new StringBuilder();

        Deque<exercisebook.Main.Frame> stack = new ArrayDeque<>();
        stack.offerLast(new exercisebook.Main.Frame(0, 0));

        while (!stack.isEmpty()) {
            exercisebook.Main.Frame current = stack.peekLast();

            if (current.depth == m) {
                for (int x : pick) sb.append(x).append(' ');
                sb.setLength(sb.length() - 1);
                sb.append('\n');
                stack.pollLast();
                if (current.chosen != -1) used[current.chosen] = false;
                continue;
            }

            int next = current.nextIdx;
            while (next < n && used[next]) next++;

            if (next == n) {
                stack.pollLast();
                if (current.chosen != -1) used[current.chosen] = false;
                continue;
            }

            current.nextIdx = next + 1;
            used[next] = true;
            pick[current.depth] = arr[next];
            current = new exercisebook.Main.Frame(current.depth + 1, 0);
            current.chosen = next;
            stack.offerLast(current);
        }
        System.out.print(sb);
    }
}