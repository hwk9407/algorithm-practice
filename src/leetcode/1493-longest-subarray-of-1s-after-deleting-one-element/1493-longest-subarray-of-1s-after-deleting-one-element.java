class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCnt = 0;
        int answer = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zeroCnt++;

            while (zeroCnt > 1) {
                if (nums[left] == 0) zeroCnt--;
                left++;
            }
            answer = Math.max(answer, right - left);
            right++;
        }

        return answer;
    }
}