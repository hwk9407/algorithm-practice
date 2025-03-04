class Solution {
    boolean solution(String s) {
        int n = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                n++;
            } else if (c == ')') {
                if (n == 0) {
                    return false;
                }
                n--;
            }
        }
        
        return n == 0;
    }
}