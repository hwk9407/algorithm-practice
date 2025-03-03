class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        sb.replace(0, sb.length() - 4, "*".repeat(sb.length() - 4));
        String answer = sb.toString();
        return answer;
    }
}