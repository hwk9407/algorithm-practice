package leetcode.java;

/*
2025-02-04
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
1342. Number of Steps to Reduce a Number to Zero
짝수면 2로 나누고
홀수면 1을 빼고
해서 0을 만드는 데 걸린 단계수를 구하는 함수 만들기
 */
class Solution1342 {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution1342 sol = new Solution1342();
        System.out.println(sol.numberOfSteps(123));
    }
}