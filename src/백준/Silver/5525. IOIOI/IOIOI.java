import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int combo = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (sb.isEmpty()) {
                if (c == 'I') sb.append(c);
                continue;
            }
            if (sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
            } else {
                if ((sb.length() - 1) / 2 - n + 1 > 0){
                combo += (sb.length() - 1) / 2 - n + 1;
                }
                sb.setLength(0);
                if (c == 'I') sb.append(c);
            }
        }
        if ((sb.length() - 1) / 2 - n + 1 > 0) {
            combo += (sb.length() - 1) / 2 - n + 1;
        }
        System.out.println(combo);
    }
}