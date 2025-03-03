class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String numString : split) {
            min = Math.min(Integer.parseInt(numString), min);
            max = Math.max(Integer.parseInt(numString), max);
        }
        answer = min + " " + max;
        return answer;
    }
}