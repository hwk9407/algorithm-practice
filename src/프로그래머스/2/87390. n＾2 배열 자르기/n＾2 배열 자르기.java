class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left) + 1;
        int[] answer = new int[size];

        for (int i = 0; i < answer.length; i++) {
            int a = (int) ((i + left) / n);
            int b = (int) ((i + left) % n);

            answer[i] = b <= a ? a + 1 : b + 1;
        }
        
        return answer;
    }
}