package programmers.java.deque;

class Solution12909 {

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

    public static void main(String[] args) {
        Solution12909 sol = new Solution12909();
        boolean flag = sol.solution("(()(");
        System.out.println(flag);
    }
}