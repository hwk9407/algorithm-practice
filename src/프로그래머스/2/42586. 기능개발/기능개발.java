import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] restDay = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            restDay[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            System.out.println(Arrays.toString(restDay));
        }
        Queue<Integer> deployQueue = new LinkedList<>();
        int count = 0;
        int prev = restDay[0];

        for (int day : restDay) {
            if (day <= prev) {
                count++;
            } else {
                prev = day;
                deployQueue.add(count);
                count = 1;
            }
        }
        deployQueue.add(count);
        
        return deployQueue.stream().mapToInt(Integer::intValue).toArray();
    }
}