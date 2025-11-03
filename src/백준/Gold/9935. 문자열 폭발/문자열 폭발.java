import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sb.append(ch);
            if (sb.length() >= bomb.length()) {
                int diff = sb.length() - bomb.length();
                boolean flag = true;
                for (int i = 0; i < bomb.length(); i++) {
                    if (sb.charAt(i + diff) != bomb.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) sb.setLength(diff);
            }
        }
        if (sb.length() == 0) sb.append("FRULA");
        System.out.println(sb);
    }
}