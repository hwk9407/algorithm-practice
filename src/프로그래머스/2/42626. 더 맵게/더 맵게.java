import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int n : scoville) {
            queue.add(n);
        }
        int min = queue.peek();
        int answer = 0;
        while (min < K) {
            if (queue.size() < 2) {
                answer = -1;
                break;
            }
            int one = queue.poll();
            int two = queue.poll();
            queue.add(one + (two * 2));
            min = queue.peek();
            answer++;
        }
        
        return answer;
    }
}