import java.util.Stack;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        int size = s.length();

        for (int i = 0; i < size; i++) {
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(i));
            for (int j = 1; j < size; j++) {
                int idx = (i + j) % size;
                if (stack.isEmpty()) {
                    stack.push(s.charAt(idx));
                    continue;
                }
                if (stack.peek() == ')' || stack.peek() == ']' || stack.peek() == '}') break;
                if (stack.peek() == '(' && s.charAt(idx) == ')' ||
                stack.peek() == '[' && s.charAt(idx) == ']' ||
                stack.peek() == '{' && s.charAt(idx) == '}') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(idx));
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}