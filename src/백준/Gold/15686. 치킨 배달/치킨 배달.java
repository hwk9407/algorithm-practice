import java.util.*;
import java.io.*;

public class Main {
    private static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> house = new ArrayList<>();
        List<int[]> chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) house.add(new int[]{i, j});
                if (a == 2) chicken.add(new int[]{i, j});
            }
        }
        int houseSize = house.size();
        int chickenSize = chicken.size();

        int[][] dist = new int[houseSize][chickenSize];
        for (int h = 0; h < houseSize; h++) {
            for (int c = 0; c < chickenSize; c++) {
                dist[h][c] = Math.abs(house.get(h)[0] - chicken.get(c)[0]) + Math.abs(house.get(h)[1] - chicken.get(c)[1]);
            }
        }
        int[] picked = new int[m];
        dfs(dist, m, picked, 0, 0);
        System.out.println(minDist);
    }

    private static void dfs(int[][] dist, int m, int[] picked, int depth, int idx) {
        if (depth == m) {
            int sum = 0;

            for (int h = 0; h < dist.length; h++) {
                int distance = Integer.MAX_VALUE;
                for (int c = 0; c < m; c++) {
                    distance = Math.min(distance, dist[h][picked[c]]);
                }
                sum += distance;
                if (sum >= minDist) return;
            }
            minDist = Math.min(minDist, sum);
            return;
        }
        for (int pickedChickenIdx = idx; pickedChickenIdx < dist[0].length; pickedChickenIdx++) {
            picked[depth] = pickedChickenIdx;
            dfs(dist, m, picked, depth + 1, pickedChickenIdx + 1);
        }

    }
}