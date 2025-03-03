class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = Character.getNumericValue(s.charAt(answer.length - 1 - i));
        }
        return answer;
    }
}