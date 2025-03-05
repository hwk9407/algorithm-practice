class Solution {
    public int solution(int n) {
        int nCount = Integer.bitCount(n);
        while(true) {
            if (nCount == Integer.bitCount(++n)) {
                return n;
            }
            
        }
    }
}
// 10
// 11
// 100 <-

// 1001110  4
// 1001111  5
// 1010011 +16-8-4

// 1111     4
// 10111    1
// 1+2+4

// 1001110

// 1을 더했더니 1의 갯수가 증가
// 0 두 개 바꿔주기

// 1을 더했더니 그대로임 바로 끗


// 1을 더했더니 1의 갯수가 감소
// 감소한 갯수 n 만큼 덧셈 2^n - 1
// 11111011111
// 11111100000
