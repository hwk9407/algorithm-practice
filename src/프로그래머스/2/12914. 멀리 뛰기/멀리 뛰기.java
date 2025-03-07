class Solution {
    private static int[] arr = new int[2001];
    public long solution(int n) {
        
        long answer = jump(n);
        return answer;
    }
    
    private int jump(int num) {
        if (num <= 2) return num;
        if (arr[num] == 0) {
            arr[num] = (jump(num - 2) + jump(num - 1)) % 1234567;
        }
        return arr[num];
    }
}