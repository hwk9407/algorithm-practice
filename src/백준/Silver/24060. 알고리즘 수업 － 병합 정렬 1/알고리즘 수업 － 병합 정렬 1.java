import java.util.*;
import java.io.*;

public class Main {
    private static int[] arr;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n - 1, k);
        if (count < k) System.out.println(-1);
    }

    private static void mergeSort(int left, int right, int target) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(left, mid, target);
        mergeSort(mid + 1, right, target);
        merge(left, mid, right, target);
    }

    private static void merge(int left, int mid, int right, int target) {
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        i = left;
        k = 0;
        while (i <= right) {
            count++;
            if (target == count) System.out.println(temp[k]);
            arr[i++] = temp[k++];
        }
    }
}