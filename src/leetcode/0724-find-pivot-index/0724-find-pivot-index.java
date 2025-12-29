class Solution {
    public int pivotIndex(int[] nums) {
        int lSum = 0, rSum = 0;
        int answer = -1;

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            rSum -= nums[i];
            if (lSum == rSum) {
                answer = i;
                break;
            }
            lSum += nums[i];
        }

        return answer;
    }
}