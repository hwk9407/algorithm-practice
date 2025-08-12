import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0")) return;

            int size = line.length();
            boolean isPalindrome = true;
            for (int left = 0; left < size / 2; left++) {
                int right = size - left - 1;
                if (line.charAt(left) != line.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) System.out.println("yes");
            else System.out.println("no");
        }
    }
}