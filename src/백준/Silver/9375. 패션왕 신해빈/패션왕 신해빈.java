import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String key = st.nextToken();
                map.merge(key, 1, Integer::sum);
            }
            int total;
            if (map.size() == 1) {
                total = map.values().iterator().next();
            } else {
                total = map.values().stream()
                        .mapToInt(v -> v + 1)
                        .reduce(1, (a, b) -> a * b) - 1;
            }
            System.out.println(total);
        }
    }
}