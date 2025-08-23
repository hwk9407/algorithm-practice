import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[] arr = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            arr[i] = name;
            map.put(name, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                sb.append(arr[Integer.parseInt(question)]).append("\n");
            } else {
                sb.append(map.get(question)).append("\n");
            }
        }
        System.out.print(sb);
    }
}