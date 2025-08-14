import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] temp = new int[n];
        mergeSort(arr, temp, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return;
        int m = left + ((right - left) >>> 1);
        mergeSort(arr, temp, left, m);
        mergeSort(arr, temp, m + 1, right);

        if (arr[m] <= arr[m + 1]) return;
        merge(arr, temp, left, m, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int m, int right) {
        int i = left;
        int j = m + 1;
        int k = left;
        while (i <= m && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= m) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, left, arr, left, right - left + 1);
    }
}