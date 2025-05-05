class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int rest = n % 3;
            if (rest == 0) {
                sb.insert(0, "4");
                n = n / 3 - 1;
            } else {
                sb.insert(0, rest);
                n /= 3;
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}