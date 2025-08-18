import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = -1;

        for (int i = n / 5; i >= 0; i--) {
            int rest = n - (i * 5);
            if (rest % 3 == 0) {
                result = i + (rest / 3);
                break;
            }
        }
        System.out.println(result);
    }
}