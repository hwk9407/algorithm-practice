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
        
        int[] count = new int[10];
        int left = 0, right = 0;
        int typeCount = 0;
        int max = 0;

        while (right < n) {
            if (count[arr[right]] == 0) typeCount++;
            count[arr[right++]]++;

            while (typeCount > 2) {
                count[arr[left]]--;
                if (count[arr[left]] == 0) typeCount--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        
        System.out.println(max);
    }
}
