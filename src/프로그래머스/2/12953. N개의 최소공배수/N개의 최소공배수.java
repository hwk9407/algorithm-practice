class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm * arr[i] / gcd(lcm, arr[i]);
        }
        return lcm;
    }
    
    private int gcd(int a, int b) {
        int rest = 0;
        while (b != 0) {
            rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }
}