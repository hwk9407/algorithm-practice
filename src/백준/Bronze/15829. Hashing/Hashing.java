
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int r = 31;
        int m = 1234567891;

        long result = 0;
        long pow = 1;
        for (int i = 0; i < l; i++) {
            int num = str.charAt(i) - 'a' + 1;
            result = (result + num * pow) % m;
            pow = (pow * r) % m;
        }
        System.out.println(result);
    }
}
