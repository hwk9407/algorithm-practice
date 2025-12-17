class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int zeroCnt = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            } else {
                zeroCnt++;
            }
        }
        for (int i = 0; i < zeroCnt; i++) {
            nums[len - 1 - i] = 0;
        }
    }
}