class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0, sum = sequence[0], length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (true) {
            if (sum < k) {
                right++;
                if (right == sequence.length) break;
                sum += sequence[right];
            }
            else if (sum >= k) {
                if (sum == k && length > right - left) {
                    length = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;
                if (left == sequence.length) break;
            }
        }
        
        return answer;
    }
}