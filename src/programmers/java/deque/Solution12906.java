package programmers.java.deque;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution12906 {

    public int[] solution(int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        int prev = -1;

        for (int num : arr) {
            if (prev != num) {
                q.add(num);
                prev = num;
            }
        }
        return q.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution12906 sol = new Solution12906();
        int[] result = sol.solution(new int[]{4, 4, 4, 3, 3});
        System.out.println(Arrays.toString(result));
    }
}