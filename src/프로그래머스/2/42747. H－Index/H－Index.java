import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int h = citations[i];
            if (h <= answer) break;
            answer++;
        }
        
        return answer;
    }
}