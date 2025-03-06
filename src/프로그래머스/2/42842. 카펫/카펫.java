class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // {가로, 세로}
        int sum = brown + yellow;
        for (int x = sum / 3; x >= 3; x--) {
            if (sum % x == 0) {
                if ((x - 2) * (sum / x - 2) != yellow) continue;
                answer[0] = x;
                answer[1] = sum / x;
                break;
            }
        }
        
        return answer;
    }
}