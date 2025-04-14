class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for (int i = 0; i < len; i++) {
            long number = numbers[i];
            if (number % 2 == 0) {
                answer[i] = number + 1;
                continue;
            }
            String s = Long.toBinaryString(number);
            StringBuilder sb = new StringBuilder(s);
            sb.insert(0, "0");
            
            int lastZeroIdx = sb.lastIndexOf("01");
            sb.replace(lastZeroIdx, lastZeroIdx + 2, "10");
            answer[i] = Long.parseLong(sb.toString(), 2);
        }
        
        return answer;
    }
}

// 짝수 일 때, 개간단 걍 1더하면됨
// 홀수 일 때
// 1. 2진법으로 바꿈 (Long.toBinaryString())
// 2. 앞에 0을 하나 붙임
// 3. 맨 오른쪽(작은 수)부터 왼쪽으로 가면서 0을 찾음
// 4. 가장 처음발견한 0을 1로 바꾸고 그 오른쪽에 있는 수를 0으로 바꿈 01 -> 10
// 5. 그값을 long 타입으로 변경 (Long.parseLong(.., 2))
// 6. long배열에 저장
// 7. 최종 반환
