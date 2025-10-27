import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] output = new char[n][(2 * n) - 1];
        for (int i = 0; i < n; i++) Arrays.fill(output[i], ' ');
        drawTriangle(output, 0, n - 1, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(output[i]).append('\n');
        System.out.print(sb);
    }

    private static void drawTriangle(char[][] output, int row, int col, int size) {
        if (size == 3) {
            output[row][col] = '*';
            output[row + 1][col - 1] = '*';
            output[row + 1][col + 1] = '*';
            output[row + 2][col - 2] = '*';
            output[row + 2][col - 1] = '*';
            output[row + 2][col] = '*';
            output[row + 2][col + 1] = '*';
            output[row + 2][col + 2] = '*';
            return;
        }
        int half = size / 2;
        drawTriangle(output, row, col, half);
        drawTriangle(output, row + half, col - half, half);
        drawTriangle(output, row + half, col + half, half);
    }
}