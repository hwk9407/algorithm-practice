
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sizes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] lines = br.readLine().split(" ");
        int t = Integer.parseInt(lines[0]);
        int p = Integer.parseInt(lines[1]);

        int result1 = 0;
        for (int size : sizes) {
            result1 += size / t;
            result1 = size % t == 0 ? result1 : result1 + 1;
        }

        int[] result2 = new int[]{(n / p), (n % p)};
        System.out.println(result1);
        System.out.println(result2[0] + " " + result2[1]);
    }
}
