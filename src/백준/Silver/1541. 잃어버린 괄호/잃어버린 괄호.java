import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int total = 0;
        boolean isFirst = true;
        while (st.hasMoreTokens()) {
            String section = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(section, "+");
            int sum = 0;
            while (st2.hasMoreTokens()) {
                sum += Integer.parseInt(st2.nextToken());
            }
            if (isFirst) {
                total += sum;
                isFirst = false;
                continue;
            }
            total -= sum;
        }
        System.out.println(total);
    }
}