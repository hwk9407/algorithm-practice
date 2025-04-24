class Solution {
    public int solution(int storey) {
        // storey의 각 자리수가 6이상이면 + 2(10 - n)한다.
        // 각 자리수별로 5보다 작으면 그대로 answer에 더함
        int answer = 0;
        while(storey > 0) {
            int rest = storey % 10;
            if (rest > 5) {
                storey += 10;
                answer += 10 - rest;
            } else if (rest == 5) {
                int next = (storey / 10) % 10;
                if (next >= 5) {
                    storey += 10;
                    answer += 10 - rest;
                } else {
                    answer += rest;
                }
            } else {
                answer += rest;
            }
            storey /= 10;
        }
        
        return answer;
    }
}