class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zeroCnt = 0;
        int answer = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zeroCnt++;

            while (zeroCnt > k) {
                if (nums[left] == 0) zeroCnt--;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        
        return answer;
    }
}