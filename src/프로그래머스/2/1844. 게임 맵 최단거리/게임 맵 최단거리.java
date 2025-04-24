import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 1, 0, -1}; // 남 동 북 서
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        maps[0][0] = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int move = current[2];
            
            if (x == maps[0].length - 1 && y == maps.length - 1) return move;
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= maps[0].length || ny >= maps.length || maps[ny][nx] == 0) {
                    continue;
                }
                
                maps[ny][nx] = 0;
                queue.add(new int[]{nx, ny, move + 1});
            }
        }
        return -1;
    }
}