import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] room = new int[r][c];
        int cleaner1 = 0;
        int cleaner2 = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && cleaner2 == 0) {
                    cleaner1 = i;
                    cleaner2 = i + 1;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            room = spread(room, r, c);
            cleanup(room, cleaner1, cleaner2);
        }
        
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] == -1) continue;
                sum += room[i][j];
            }
        }
        System.out.println(sum);
    }

    private static int[][] spread(int[][] room, int r, int c) {
        int[][] after = new int[r][c];
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (room[y][x] < 5) {
                    after[y][x] += room[y][x];
                    continue;
                }
                int val = room[y][x] / 5;
                int moveCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (!isMovable(room, nx, ny)) continue;
                    after[ny][nx] += val;
                    moveCnt++;
                }
                after[y][x] += room[y][x] - (val * moveCnt);
            }
        }

        return after;
    }

    private static boolean isMovable(int[][] room, int x, int y) {
        if (x < 0 || y < 0 || x >= room[0].length || y >= room.length) return false;
        return room[y][x] != -1;
    }

    private static void cleanup(int[][] room, int cleaner1, int cleaner2) {

        Queue<Integer> q1 = new LinkedList<>();
        int idx = 0;
        int[] current = new int[]{1, cleaner1};
        q1.offer(0);
        while (true) {
            q1.offer(room[current[1]][current[0]]);
            int nx = dx[idx] + current[0];
            int ny = dy[idx] + current[1];
            if (!isMovable(room, nx, ny)) {
                idx++;
                if (idx >= 4) break;
                nx = dx[idx] + current[0];
                ny = dy[idx] + current[1];
            }
            current[0] = nx;
            current[1] = ny;
        }

        current = new int[]{1, cleaner1};
        idx = 0;
        while (true) {
            room[current[1]][current[0]] = q1.poll();
            int nx = dx[idx] + current[0];
            int ny = dy[idx] + current[1];
            if (!isMovable(room, nx, ny)) {
                idx++;
                if (idx >= 4) break;
                nx = dx[idx] + current[0];
                ny = dy[idx] + current[1];
            }
            current[0] = nx;
            current[1] = ny;
        }


        Queue<Integer> q2 = new LinkedList<>();
        idx = 0;
        current = new int[]{1, cleaner2};
        q2.offer(0);
        while (true) {
            q2.offer(room[current[1]][current[0]]);
            int nx = dx[idx] + current[0];
            int ny = dy[(idx + 2) % 4] + current[1];
            if (!isMovable(room, nx, ny)) {
                idx++;
                if (idx >= 4) break;
                nx = dx[idx] + current[0];
                ny = dy[(idx + 2) % 4] + current[1];
            }
            current[0] = nx;
            current[1] = ny;
        }

        current = new int[]{1, cleaner2};
        idx = 0;
        while (true) {
            room[current[1]][current[0]] = q2.poll();
            int nx = dx[idx] + current[0];
            int ny = dy[(idx + 2) % 4] + current[1];
            if (!isMovable(room, nx, ny)) {
                idx++;
                if (idx >= 4) break;
                nx = dx[idx] + current[0];
                ny = dy[(idx + 2) % 4] + current[1];
            }
            current[0] = nx;
            current[1] = ny;
        }
    }
}
