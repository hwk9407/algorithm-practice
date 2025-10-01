import java.util.*;
import java.io.*;

public class Main {
    private static class Frame {
        int depth;
        int next;
        int picked;

        Frame(int depth, int next, int picked) {
            this.depth = depth;
            this.next = next;
            this.picked = picked;
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

        int[] path = new int[m];
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            Arrays.fill(visited, false);
            visited[i] = true;
            path[0] = arr[i];

            Deque<exercisebook.Main.Frame> stack = new ArrayDeque<>();
            stack.offerLast(new exercisebook.Main.Frame(1, 0, i));

            while (!stack.isEmpty()) {
                exercisebook.Main.Frame current = stack.peekLast();
                if (current.depth == m) {
                    for (int x : path) sb.append(x).append(' ');
                    sb.append('\n');

                    exercisebook.Main.Frame child = stack.pollLast();
                    visited[child.picked] = false;
                    continue;
                }

                boolean pushed = false;
                for (int j = current.next; j < n; j++) {
                    if (visited[j]) continue;
                    if (j > 0 && arr[j] == arr[j - 1] && !visited[j - 1]) continue;
                    visited[j] = true;
                    path[current.depth] = arr[j];
                    current.next = j + 1;
                    stack.offerLast(new exercisebook.Main.Frame(current.depth + 1, 0, j));
                    pushed = true;
                    break;
                }
                if (pushed) continue;

                exercisebook.Main.Frame child = stack.pollLast();
                visited[child.picked] = false;
            }
        }

        System.out.print(sb);
    }
}