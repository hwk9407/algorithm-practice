import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int n = land.length;

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < 4; col++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == col) continue;
                    max = Math.max(max, land[row - 1][k]);
                }
                land[row][col] += max;
            }
        }

        int answer = 0;
        for (int col = 0; col < 4; col++) {
            answer = Math.max(answer, land[n - 1][col]);
        }
        return answer;
    }
}