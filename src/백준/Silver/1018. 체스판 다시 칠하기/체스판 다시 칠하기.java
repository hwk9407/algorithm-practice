import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] ch = line.toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = ch[j];
            }
        }
        int changeCount = 64;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int cnt = count(board, 'B', i, j, changeCount);
                cnt = Math.min(count(board, 'W', i, j, changeCount), cnt);
                changeCount = Math.min(cnt, changeCount);
            }
        }

        System.out.println(changeCount);
    }

    private static int count(char[][] board, char startChar, int startRow, int startCol, int minCount) {
        char[] check = new char[]{'B', 'W'};
        int idx = startChar == 'B' ? 0 : 1;
        int count = 0;
        for (int i = startRow; i < 8 + startRow; i++) {
            for (int j = startCol; j < 8 + startCol; j++) {
                if (minCount <= count) {
                    return count;
                }
                if (check[idx % 2] == board[i][j]) count++;
                idx++;
            }
            idx++;
        }

        return count;
    }
}