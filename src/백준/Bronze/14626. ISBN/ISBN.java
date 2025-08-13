import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        int result = 0;
        int idx = -1;
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (c == '*') {
                idx = i;
                continue;
            }
            int num = c - '0';
            if (i % 2 == 1) num *= 3;
            result += num;
        }
        if (idx == isbn.length() - 1) {
            int x = (10 - (result % 10)) % 10;
            System.out.println(x);
            return;
        }
        int weight = idx % 2 == 1 ? 3 : 1;
        for (int x = 0; x <= 9; x++) {
            int sum = result + weight * x;
            if (sum % 10 == 0) {
                System.out.println(x);
                break;
            }
        }
    }
}