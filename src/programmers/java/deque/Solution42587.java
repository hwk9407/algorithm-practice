package programmers.java.deque;

import java.util.*;

class Solution42587 {

    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> sortedPriorities = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
            sortedPriorities.add(priorities[i]);
        }
        sortedPriorities.sort(Collections.reverseOrder());
        int executionOrder = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int priority = current[0];
            int index = current[1];

            if (priority == sortedPriorities.get(executionOrder)) {
                executionOrder++;
                if (index == location) {
                    return executionOrder;
                }
            } else {
                queue.offer(current);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution42587 sol = new Solution42587();
        System.out.println(sol.solution(new int[]{1, 2, 3, 2}, 2));
    }
}