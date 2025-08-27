import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lanSize = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            lanSize[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanSize[i]);
        }
        long left = 1;
        long right = (long) max + 1;
        while (left < right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += lanSize[i] / mid;
            }
            if (cnt < n) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        System.out.println(left - 1);
    }
}