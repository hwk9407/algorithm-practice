import java.util.*;
import java.io.*;

public class Main {
    static int sharkSize = 2;
    static int eatenFish = 0;
    static int[] dx = new int[]{0, -1, 1, 0};
    static int[] dy = new int[]{-1, 0, 0, 1};

    static class Shark {
        int x, y;
        int dist;

        Shark(int x, int y) {
            this(x, y, 0);
        }

        Shark(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N][N];
        Shark rootShark = null;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 9) {
                    rootShark = new Shark(j, i);
                    maps[i][j] = 0;
                }
            }
        }

        int result = 0;
        while (true) {
            rootShark = bfs(maps, N, rootShark);
            if (rootShark == null) break;
            result = rootShark.dist;
        }
        System.out.println(result);
    }

    private static Shark bfs(int[][] maps, int N, Shark shark) {
        Deque<Shark> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        visited[shark.y][shark.x] = true;
        queue.offerLast(shark);

        List<int[]> candidates = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Shark current = queue.pollFirst();
            if (minDist < current.dist) continue;
            if (maps[current.y][current.x] != 0 && maps[current.y][current.x] < sharkSize) {
                candidates.add(new int[]{current.x, current.y});
                minDist = current.dist;
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (sharkSize < maps[ny][nx]) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.offerLast(new Shark(nx, ny, current.dist + 1));
            }
        }

        candidates.sort((c1, c2) -> {
            if (c1[1] != c2[1]) return Integer.compare(c1[1], c2[1]);
            else return Integer.compare(c1[0], c2[0]);
        });
        if (candidates.isEmpty()) return null;

        int[] fish = new int[]{candidates.get(0)[0], candidates.get(0)[1]};
        maps[fish[1]][fish[0]] = 0;
        eatFish();
        return new Shark(fish[0], fish[1], minDist);
    }

    private static void eatFish() {
        eatenFish++;
        if (eatenFish == sharkSize) {
            eatenFish = 0;
            sharkSize++;
        }
    }
}