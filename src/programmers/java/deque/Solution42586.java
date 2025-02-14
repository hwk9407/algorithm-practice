package programmers.java.deque;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] restDay = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            restDay[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
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

    public static void main(String[] args) {
        Solution42586 sol = new Solution42586();
        System.out.println(Arrays.toString(sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));

    }
}