class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(grid[row][col]).append(',');
            }
            sb.setLength(sb.length() - 1);
            String key = sb.toString();
            map.merge(key, 1, Integer::sum);
        }

        int answer = 0;
        for (int col = 0; col < n; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < n; row++) {
                sb.append(grid[row][col]).append(',');
            }
            sb.setLength(sb.length() - 1);
            String key = sb.toString();
            answer += map.getOrDefault(key, 0);
        }

        return answer;
    }
}