import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] campus = new char[n][m];
        boolean[][] isVisited = new boolean[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    start[0] = j;
                    start[1] = i;
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(start);
        isVisited[start[1]][start[0]] = true;
        int cnt = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();

            if (campus[current[1]][current[0]] == 'P') cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (campus[ny][nx] == 'X' || isVisited[ny][nx]) continue;
                isVisited[ny][nx] = true;
                queue.offerLast(new int[]{nx, ny});
            }
        }

        System.out.println(cnt == 0 ? "TT" : cnt);
    }
}