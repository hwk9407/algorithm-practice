package programmers.java.sort;

import java.util.Arrays;

class Solution42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.stream(Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]))
                    .sorted()
                    .toArray();
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution42748 sol = new Solution42748();
        int[] answer = sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(answer));
    }
}