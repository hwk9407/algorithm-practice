class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayGcd(arrayA);
        int gcdB = arrayGcd(arrayB);
        int answer = 0;
        for (int i = 2; i < (int) Math.sqrt(gcdA); i++) {
            if (gcdA % i != 0) continue;
            if (isValid(i, arrayB)) answer = Math.max(answer, i);
            if (isValid(gcdB / i, arrayB)) answer = Math.max(answer, gcdA / i);
        }
        for (int i = 2; i < (int) Math.sqrt(gcdB); i++) {
            if (gcdB % i != 0) continue;
            if (isValid(i, arrayA)) answer = Math.max(answer, i);
            if (isValid(gcdB / i, arrayA)) answer = Math.max(answer, gcdB / i);
        }
        if (isValid(gcdB, arrayA)) answer = Math.max(answer, gcdB);
        if (isValid(gcdA, arrayB)) answer = Math.max(answer, gcdA);
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    private int arrayGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
    
    private boolean isValid(int n, int[] arr) {
        if (n == 0) return false;
        for (int a : arr) {
            if (a % n == 0) return false;
        }
        return true;
    }
}


// arrayA, arrayB의 각각 최대공약수를 구함
// result의 초기값은 0
// 1보다큰 arrayA의 GCD의 약수가 arrayB에 나눴을 때 나머지가 있는 경우 result에 추가
// 반대로 1보다 큰 arrayB의 GCD의 약수가 arrayA에 나눴을 때 나머지가 있는 경우 result에 Math.max(result, 해당 약수) 추가