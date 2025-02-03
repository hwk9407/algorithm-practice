package leetcode.java;

import java.util.ArrayList;
import java.util.List;

/*
2025-02-03
https://leetcode.com/problems/fizz-buzz/description/
412. Fizz Buzz
int n이 주어지고, 인덱스가 1부터 시작하는 문자열 배열 answer를 반환하라
조건
- 3, 5로 나누어 떨어지면 FizzBuzz
- 3으로 나누어 떨어지면 Fizz
- 5로 나누어 떨어지면 Buzz
- 그 외엔 i(문자열 데이터타입의 숫자)
 */
class Solution412 {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");
            result.add(sb.isEmpty() ? Integer.toString(i) : sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution412 sol = new Solution412();
        System.out.println(sol.fizzBuzz(15));
    }
}