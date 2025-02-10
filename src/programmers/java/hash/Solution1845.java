package programmers.java.hash;

import java.util.HashSet;

class Solution1845 {

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        Solution1845 sol = new Solution1845();
        System.out.println(sol.solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}