import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String command = line[0];
            switch(command) {
                case "add" -> {
                    int value = Integer.parseInt(line[1]);
                    arr[value] = true;
                } case "remove" -> {
                    int value = Integer.parseInt(line[1]);
                    arr[value] = false;
                } case "check" -> {
                    int value = Integer.parseInt(line[1]);
                    sb.append(arr[value] ? "1" : "0").append("\n");
                } case "toggle" -> {
                    int value = Integer.parseInt(line[1]);
                    arr[value] = !arr[value];
                } case "all" -> {
                    Arrays.fill(arr, true);
                } case "empty" -> {
                    Arrays.fill(arr, false);
                }
            }
        }
        System.out.print(sb);
    }
}