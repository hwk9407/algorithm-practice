import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> a = new HashSet<>();
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(line[i]));
        }
        int m = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(line[i]);
            if (a.contains(num)) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}