import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            map.put(line[0], line[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            sb.append(map.get(question)).append("\n");
        }
        System.out.print(sb);
    }
}