import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        int x;
        int y;
        int size;

        public Node (int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                maps[i][j] = val;
            }
        }
        int[] result = divideAndConquer(maps, n);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static int[] divideAndConquer(int[][] maps, int size) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerLast(new Node(0, 0, size));
        int[] result = new int[2];

        while (!stack.isEmpty()) {
            Node current = stack.pollLast();
            int color = maps[current.y][current.x];
            boolean isMixed = false;
            if (current.size == 1) {
                result[color]++;
                continue;
            }
            for (int y = current.y; y < current.y + current.size; y++) {
                for (int x = current.x; x < current.x + current.size; x++) {
                    if (maps[y][x] != color) {
                        isMixed = true;
                        int nextSize = current.size / 2;
                        stack.offerLast(new Node(current.x, current.y, nextSize));
                        stack.offerLast(new Node(current.x + nextSize, current.y, nextSize));
                        stack.offerLast(new Node(current.x, current.y + nextSize, nextSize));
                        stack.offerLast(new Node(current.x + nextSize, current.y + nextSize, nextSize));
                        break;
                    }
                }
                if (isMixed) {
                    break;
                }
            }
            if (!isMixed) {
                result[color]++;
            }
        }

        return result;
    }
}