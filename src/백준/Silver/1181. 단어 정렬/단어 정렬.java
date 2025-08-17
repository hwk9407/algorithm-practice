import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Comparator<String> comp = (s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            else return s1.compareTo(s2);
        };
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(comp);
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}