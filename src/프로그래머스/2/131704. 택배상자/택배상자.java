import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> temp = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            queue.add(i);
        }
        int answer = 0;
        while (!queue.isEmpty() || !temp.isEmpty() && temp.peek() == order[answer]) {
            // 스택이 null 이 아니면 temp 도 보셈.
            if (!temp.isEmpty() && temp.peek() == order[answer]) {
                temp.pop();
                answer++;
            } else if (queue.peek() == order[answer]) {
                queue.poll();
                answer++;
            } else {
                temp.add(queue.poll());
            }
        }

        return answer;
    }
}