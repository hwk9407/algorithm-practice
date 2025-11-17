import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();
        int startA = 0;
        int startB = 0;

        while (true) {
            int maxA = -1;
            int maxB = -1;

            for (int i = startA; i < n; i++) {
                maxA = Math.max(maxA, a[i]);
            }
            for (int i = startB; i < m; i++) {
                maxB = Math.max(maxB, b[i]);
            }

            int commonMax = -1;

            for (int target = Math.min(maxA, maxB); target >= 1; target--) {
                boolean existsInA = false;
                boolean existsInB = false;

                for (int i = startA; i < n; i++) {
                    if (a[i] == target) {
                        existsInA = true;
                        break;
                    }
                }
                for (int i = startB; i < m; i++) {
                    if (b[i] == target) {
                        existsInB = true;
                        break;
                    }
                }

                if (existsInA && existsInB) {
                    commonMax = target;
                    break;
                }
            }

            if (commonMax == -1) break;
            result.add(commonMax);

            for (int i = startA; i < n; i++) {
                if (a[i] == commonMax) {
                    startA = i + 1;
                    break;
                }
            }
            for (int i = startB; i < m; i++) {
                if (b[i] == commonMax) {
                    startB = i + 1;
                    break;
                }
            }
        }

        System.out.println(result.size());
        if (result.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int num : result) {
                sb.append(num).append(' ');
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
