class Solution {
    public int[] solution(int[][] arr) {
        int size = arr.length;
        int[] answer = new int[2];
        dfs(answer, arr, 0, 0, size);
        
        return answer;
    }
    
    private void dfs(int[] answer, int[][] arr, int x, int y, int size) {
        if (isSame(arr, x, y, size)) {
            answer[arr[y][x]]++;
            return;
        }
        
        int newSize = size / 2;
        dfs(answer, arr, x, y, newSize);
        dfs(answer, arr, x + newSize, y, newSize);
        dfs(answer, arr, x, y + newSize, newSize);
        dfs(answer, arr, x + newSize, y + newSize, newSize);
    }
    
    private boolean isSame(int[][] arr, int x, int y, int size) {
        int first = arr[y][x];
        for (int col = y; col < y + size; col++) {
            for (int row = x; row < x + size; row++) {
                if (arr[col][row] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}