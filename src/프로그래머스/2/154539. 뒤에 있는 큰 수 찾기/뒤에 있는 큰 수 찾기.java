import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for (int num = 0; num < numbers.length; num++) {
            int number = numbers[num];
            
            while (!stack.isEmpty() && numbers[stack.peek()] < number) {
                int idx = stack.pop();
                answer[idx] = number;
            }
            stack.push(num);
        }
        return answer;
    }
}