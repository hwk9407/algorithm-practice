class Solution {
    public int[] solution(int n) {
        int max = n * (n + 1) / 2;
        int[][] triangle = new int[n][n];
        
        int x = 0, y = 0, dir = 0, num = 1;
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        for (int i = 0; i < max; i++) {
            triangle[x][y] = num++;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx >= n || ny >= n || nx < 0 || ny < 0 || triangle[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
        int[] answer = new int[max];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}