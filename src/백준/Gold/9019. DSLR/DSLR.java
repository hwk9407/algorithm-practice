import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            int[] prev = new int[10000];
            char[] cmd = new char[10000];
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(a);
            visited[a] = true;
            StringBuilder sb = new StringBuilder();

            while (!queue.isEmpty()) {
                int current = queue.pollFirst();
                if (current == b) {
                    int num = b;
                    while (num != a) {
                        sb.append(cmd[num]);
                        num = prev[num];
                    }
                    break;
                }

                int[] next = new int[]{commandD(current), commandS(current), commandL(current), commandR(current)};
                char[] nextCmd = new char[]{'D', 'S', 'L', 'R'};
                for (int j = 0; j < 4; j++) {
                    int n = next[j];
                    if (!visited[n]) {
                        visited[n] = true;
                        prev[n] = current;
                        cmd[n] = nextCmd[j];
                        queue.offerLast(n);
                    }
                }
            }
            sb.reverse();
            System.out.println(sb);
        }
    }

    private static int commandL(int n) {
        n *= 10;
        int quotient = n / 10000;
        return n % 10000 + quotient;
    }

    private static int commandR(int n) {
        int remainder = n % 10;
        n /= 10;
        return remainder * 1000 + n;
    }

    private static int commandD(int n) {
        n *= 2;
        return n % 10000;
    }

    private static int commandS(int n) {
        if (n == 0) return 9999;
        return n - 1;
    }
}