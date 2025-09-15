import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Deque<Integer> deque = parseDeque(s);
            boolean reversed = false;
            boolean errorFlag = false;
            for (char ch : p.toCharArray()) {
                if (ch == 'R') {
                    reversed = !reversed;
                } else if(ch == 'D') {
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    if (!reversed) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (errorFlag) {
                sb.append("error").append('\n');
                continue;
            }
            if (deque.isEmpty()) {
                sb.append("[]").append('\n');
                continue;
            }
            sb.append('[');
            while (!deque.isEmpty()) {
                if (!reversed) sb.append(deque.pollFirst());
                else sb.append(deque.pollLast());
                sb.append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(']').append('\n');
        }
        System.out.print(sb);
    }

    private static Deque<Integer> parseDeque(String s) {
        s = s.substring(1, s.length() - 1);
        if (s.isEmpty()) return new ArrayDeque<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (String num : s.split(",")) dq.offerLast(Integer.parseInt(num));
        return dq;
    }
}