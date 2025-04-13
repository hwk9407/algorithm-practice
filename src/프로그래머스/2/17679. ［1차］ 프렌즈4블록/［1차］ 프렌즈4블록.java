import java.util.Arrays;

class Solution {
    public int solution(int m, int n, String[] board) {
        // 보드판 만들기
        char[][] cBoard = new char[m][n];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length(); col++) {
                cBoard[row][col] = board[row].charAt(col);
            }
        }
        
        int answer = 0;
        while (true) {
            boolean[][] rBoard = new boolean[m][n];
            // 2x2 있는지 확인
            if (!checkBlock(cBoard, rBoard)) break;
            // rBoard의 true를 -로 문자 바꾸기(바꾼 갯수만큼 answer+)
            answer += removeBlock(cBoard, rBoard);
            // 블록 아래로 내리기
            downBlock(cBoard);
        }
        
        
        return answer;
    }
    
    // 2x2 있는지 확인
    private boolean checkBlock(char[][] cBoard, boolean[][] rBoard) {
        boolean result = false;
        for (int row = 0; row < cBoard.length - 1; row++) {
            for (int col = 0; col < cBoard[0].length - 1; col++) {
                if (cBoard[row][col] == '-') continue;
                if (cBoard[row][col] == cBoard[row][col + 1] &&
                   cBoard[row][col] == cBoard[row + 1][col] &&
                   cBoard[row][col] == cBoard[row + 1][col + 1]) {
                    rBoard[row][col] = true;
                    rBoard[row][col + 1] = true;
                    rBoard[row + 1][col] = true;
                    rBoard[row + 1][col + 1] = true;
                    result = true;
                }
            }
        }
        return result;
    }
    
    // rBoard의 true를 -로 문자 바꾸기(바꾼 갯수만큼 answer+)
    private int removeBlock(char[][] cBoard, boolean[][] rBoard) {
        int result = 0;
        for (int row = 0; row < rBoard.length; row++) {
            for (int col = 0; col < rBoard[0].length; col++) {
                if (rBoard[row][col]) {
                    cBoard[row][col] = '-';
                    result++;
                }
            }
        }
        return result;
    }
    
    // 블록 아래로 내리기
    private void downBlock(char[][] cBoard) {
        for (int col = 0; col < cBoard[0].length; col++) {
            char[] arrange = new char[cBoard.length];
            Arrays.fill(arrange, '-');
            int idx = cBoard.length - 1;
            
            for(int row = cBoard.length - 1; row >= 0; row--) {
                if (cBoard[row][col] != '-') arrange[idx--] = cBoard[row][col];
            }
            
            for (int row = 0; row < cBoard.length; row++) {
                cBoard[row][col] = arrange[row];
            }
        }
    }
}
// String[] -> char 2차원 배열로 변환
// 같은 문자 2x2로 있으면 지워지고(겹치기가능)
// 공중에 떠있는 것들 중력 적용(위에서 아래로)

// 바로 지우지 않고 같은 크기(m * n)의 boolean[][]을 만들어서 true로 바꾸는 걸로 하자
// boolean[]이 true인 애들을 전부 A~Z가 아닌 특수 문자로 바꾸기(-)
// 바꾸고 난 뒤 맨밑줄이 아니라면 -블록 위에 있는 문자블록들은 아래로 이동