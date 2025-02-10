package programmers.java.dp;

/*
2025-02-10
https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java
정수 삼각형
삼각형으로 꼭대기부터 바닥까지 이어지는 경로 중 거쳐간 숫자의 합이 가장 큰 경우를 찾는 문제.
아래 칸으로 이동할 때는 대각선 방향으로 왼쪽 한 칸 또는 오른쪽 한 칸만 이동 가능
거쳐간 숫자의 최대값을 return 하기


DP 동적계획법 문제
- 역순으로 연산
- 메모이제이션
- 최대값 반환
 */
class Solution43105 {

    public int solution(int[][] triangle) {
        int n = triangle.length;

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                triangle[row][col] += Math.max(triangle[row + 1][col], triangle[row + 1][col + 1]);
            }
        }

        return triangle[0][0];
    }

    public static void main(String[] args) {
        Solution43105 sol = new Solution43105();
        int result = sol.solution(new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        });
        System.out.println(result); // 예상 결과값: 30
    }
}