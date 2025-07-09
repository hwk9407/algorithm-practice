import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int digit = String.valueOf(n).length();

        int start = Math.max(1, n - 9 * digit);
        for (int i = start; i < n; i++) {
            if (n == digitSum(i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static int digitSum(int n) {
        int result = n;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}