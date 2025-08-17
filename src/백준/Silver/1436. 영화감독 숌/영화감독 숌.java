import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int i = 666;
        while (n != cnt) {
            if (String.valueOf(i).contains("666")) {
                cnt++;
            }
            i++;
        }
        System.out.println(i - 1);
    }
}