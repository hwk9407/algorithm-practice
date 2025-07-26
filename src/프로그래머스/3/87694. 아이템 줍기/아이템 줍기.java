import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[102][102];
        
        // 테두리 포함 1로 다 칠함
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        
        // 테두리 미포함 내부를 2로 칠함
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2 + 1;
            int y1 = rect[1] * 2 + 1;
            int x2 = rect[2] * 2 - 1;
            int y2 = rect[3] * 2 - 1;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 2;
                }
            }
        }
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[102][102];
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;
        
        queue.offerLast(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int y = cur[0], x = cur[1], dist = cur[2];
            
            if (y == endY && x == endX) {
                return dist / 2;
            }
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (visited[ny][nx]) continue;
                if (board[ny][nx] != 1) continue;
                
                visited[ny][nx] = true;
                queue.offerLast(new int[]{ny, nx, dist + 1});
            }
        }
        
        // 이론적으로 도달할 수 없음
        return -1;
    }
}