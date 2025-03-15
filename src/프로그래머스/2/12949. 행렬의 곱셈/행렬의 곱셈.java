class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int width = arr1.length;
        int height = arr2[0].length;
        int[][] answer = new int[width][height];
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int num = 0;
                for (int idx = 0; idx <arr1[i].length; idx++) {
                    num += arr1[i][idx] * arr2[idx][j];
                }
                answer[i][j] = num;
            }
        }
        
        return answer;
    }
}