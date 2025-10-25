import java.util.*;
import java.io.*;

public class Main {
    static int maxCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] maps = new String[R];
        for (int i = 0; i < R; i++) maps[i] = br.readLine();

        boolean[] visited = new boolean[26];
        visited[maps[0].charAt(0) - 'A'] = true;
        dfs(maps, visited, 0, 0, 1);
        System.out.println(maxCnt);
    }

    private static void dfs(String[] maps, boolean[] visited, int x, int y, int cnt) {
        if (maxCnt < cnt) maxCnt = cnt;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= maps[0].length() || ny >= maps.length) continue;
            if (visited[maps[ny].charAt(nx) - 'A']) continue;
            visited[maps[ny].charAt(nx) - 'A'] = true;
            dfs(maps, visited, nx, ny, cnt + 1);
            visited[maps[ny].charAt(nx) - 'A'] = false;
        }
    }
}