import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[n];
        int len = 0;
        for (int x : arr) {
            if (len == 0 || tails[len - 1] < x) {
                tails[len++] = x;
                continue;
            }
            int idx = lowerBound(tails, 0, len, x);
            tails[idx] = x;
        }
        System.out.println(len);
    }

    private static int lowerBound(int[] arr, int left, int right, int x) {
         while (left < right) {
             int mid = (left + right) / 2;
             if (arr[mid] < x) {
                 left = mid + 1;
             } else {
                 right = mid;
             }
         }
         return left;
    }
}