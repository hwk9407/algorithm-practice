package programmers.java.sort;

import java.util.Arrays;

class Solution42746 {

    public String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, (o1, o2) -> {
            String first = o1 + o2;
            String second = o2 + o1;
            return second.compareTo(first);
        });
        answer = String.join("", strArr);

        return answer.charAt(0) == '0' ? "0" : answer;
    }

    public static void main(String[] args) {
        Solution42746 sol = new Solution42746();
        System.out.println(sol.solution(new int[]{0, 0, 0, 0}));
    }
}