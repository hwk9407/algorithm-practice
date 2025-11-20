import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점의 수 1 ~ 500
            int M = Integer.parseInt(st.nextToken()); // 도로의 개수 (양방향) 1 ~ 2500
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 개수 (단방향) 1 ~ 200

            List<int[]> edges = new ArrayList<>();
            for (int j = 0; j < M; j++) { // 도로의 정보
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()); // 도로 지점 1
                int E = Integer.parseInt(st.nextToken()); // 도로 지점 2
                int T = Integer.parseInt(st.nextToken()); // 도로를 통해 이동하는데 걸리는 시간
                edges.add(new int[]{S, E, T});
                edges.add(new int[]{E, S, T});
            }
            for (int j = 0; j < W; j++) { // 웜홀의 정보
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()); // 웜홀 시작 지점 1
                int E = Integer.parseInt(st.nextToken()); // 웜홀 도착 지점 2
                int T = Integer.parseInt(st.nextToken()); // 웜홀를 통해 이동하는데 줄어드는 시간 0 <= T <= 10,000
                edges.add(new int[]{S, E, -T});
            }

            // 벨만-포드 알고리즘
            int[] dist = new int[N + 1];
            for (int j = 0; j < N - 1; j++) {
                for (int[] edge : edges) {
                    int start = edge[0];
                    int end = edge[1];
                    int time = edge[2];
                    if (dist[start] + time < dist[end]) {
                        dist[end] = dist[start] + time;
                    }
                }
            }

            boolean flag = false;

            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int time = edge[2];
                if (dist[start] + time < dist[end]) {
                    flag = true;
                    break;
                }
            }
            
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
