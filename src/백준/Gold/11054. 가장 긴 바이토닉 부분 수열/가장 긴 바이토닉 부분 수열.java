import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] inc = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) inc[i] = Math.max(inc[i], inc[j] + 1);
            }
        }
        int[] dec = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) dec[i] = Math.max(dec[i], dec[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }
        System.out.println(max);
    }
}