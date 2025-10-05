import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = 1;
        long base = a % c;
        long exp = b;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % c;
                exp--;
            } else {
                base = (base * base) % c;
                exp /= 2;
            }
        }
        System.out.println(result);
    }
}