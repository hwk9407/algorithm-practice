import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int sx = 0, sy = 0;
        int lx = 0, ly = 0;
        for(int y = 0; y < maps.length; y++) {
            for(int x = 0; x < maps[0].length(); x++) {
                if (maps[y].charAt(x) == 'S') {
                    sx = x;
                    sy = y;
                }
                else if (maps[y].charAt(x) == 'L') {
                    lx = x;
                    ly = y;
                }
            }
        }
        
        int toLever = bfs(sx, sy, 'L', maps);
        int toEnd = bfs(lx, ly, 'E', maps);
        
        if (toLever == -1 || toEnd == -1) return -1;
        int answer = toLever + toEnd;
        return answer;
    }
    
    // 이동 가능한 곳인지
    private boolean isMoveable(int x, int y, String[] maps, boolean[][] visited) {
        // 0 <= 범위 < length, 맵이 (S, E, O) 중에 하나, !visited[y][x] 여야함
        if (x < 0 || x >= maps[0].length() || y < 0 || y >= maps.length
            || maps[y].charAt(x) == 'X' || visited[y][x])
            return false;
        return true;
    }
    
    private int bfs(int x, int y, char target, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] dx = {0, 1, 0, -1}; // 남 동 북 서
        int[] dy = {1, 0, -1, 0};
        
        // 시작 위치 
        queue.add(new int[]{x, y, 0});
        visited[y][x] = true;
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            
            if (target == maps[node[1]].charAt(node[0])) return node[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if (!isMoveable(nx, ny, maps, visited)) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {nx, ny, node[2] + 1});
            }
        }
        
        return -1;
    }
}

// bfs 문제 (최소거리 시간에 L도달 후 X도달 해야함)
// X와 배열범위 밖 빼고 다 이동 가능(S, E도 지나다닐 수 있음)
// E 도달 해도 L도달 안했으면 의미 없음.
// S -> L -> E 순으로 방문 해야함
// visited 2차원 배열을 관리.
// visited는 L 도달 후 전부 false로 fill해줘야함 (현위치는 true 해주기)
// 