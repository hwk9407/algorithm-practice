import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int offset = 0;
        while (n > 0) {
            int mid = 1 << n - 1;
            if (r >= mid) {
                offset += 1 << (2 * n) - 1;
                r %= mid;
            }
            if (c >= mid) {
                offset += 1 << 2 * n - 2;
                c %= mid;
            }
            n--;
        }
        System.out.println(offset);
    }
}