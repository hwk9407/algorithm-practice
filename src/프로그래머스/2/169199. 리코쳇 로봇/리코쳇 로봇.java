import java.util.*;

class Solution {
    public int solution(String[] board) {
        int sizeX = board[0].length();
        int sizeY = board.length;
        int[] start = null;
        int[] end = null;
        int[][] boards = new int[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                char ch = board[y].charAt(x);
                if (ch == '.') continue;
                if (ch == 'D') boards[y][x] = 1;
                if (ch == 'R') start = new int[]{x, y};
                if (ch == 'G') end = new int[]{x, y};
            }
        }
        // Node(x, y, 횟수) int[3] 으로 해결하자.
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[sizeY][sizeX];
        visited[start[1]][start[0]] = true;
        queue.offerLast(new int[]{start[0], start[1], 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];
            
            if (cx == end[0] && cy == end[1]) return cnt;
            
            for (int d = 0; d < 4; d++) {
                int[] next = move(cx, cy, d, boards);
                
                if (visited[next[1]][next[0]]) continue;
                visited[next[1]][next[0]] = true;
                queue.offerLast(new int[]{next[0], next[1], cnt + 1});
            }
        }
        
        return -1;
    }
    private int[] move(int x, int y, int direction, int[][] boards) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int nx = x;
        int ny = y;
        while(true) {
            nx += dx[direction];
            ny += dy[direction];
            if (nx < 0 || ny < 0 || nx >= boards[0].length || ny >= boards.length) break;
            if (boards[ny][nx] == 1) break;
            x = nx;
            y = ny;
        }
        return new int[]{x, y};
    }
}