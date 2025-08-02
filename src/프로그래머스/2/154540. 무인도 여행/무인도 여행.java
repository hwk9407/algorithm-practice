import java.util.*;

class Solution {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static List<Integer> result = new ArrayList<>();

    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            String row = maps[i];
            for (int j = 0; j < row.length(); j++) {
                if (visited[i][j] || maps[i].charAt(j) == 'X') continue;
                dfs(i, j, visited, maps);
            }
        }
        
        result.sort(Comparator.naturalOrder());
        
        if (result.size() == 0) return new int[]{-1};
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    private void dfs(int i, int j, boolean[][] visited, String[] maps) {
        Deque<int[]> stack = new ArrayDeque<>();
        visited[i][j] = true;
        stack.offerLast(new int[]{i, j});
        int sum = Character.getNumericValue(maps[i].charAt(j));
        
        while (!stack.isEmpty()) {
            int[] cur = stack.pollLast();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[1] + dx[d];
                int ny = cur[0] + dy[d];
                if (nx < 0 || ny < 0 || ny >= maps.length || nx >= maps[0].length() || visited[ny][nx] || maps[ny].charAt(nx) == 'X') continue;
                sum += Character.getNumericValue(maps[ny].charAt(nx));
                visited[ny][nx] = true;
                stack.offerLast(new int[]{ny, nx});
            }
        }
        result.add(sum);
    }
}