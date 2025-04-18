import java.util.*;

class Solution {
    public int solution(String numbers) {
        String[] digits = numbers.split("");
        Set<Integer> results = makeNums(digits);
        int max = 0;
        for (Integer result : results) {
            max = Math.max(result, max);
        }
        
        boolean[] isPrime = new boolean[max + 1];
        sieve(isPrime);
        
        int answer = 0;
        for (Integer result : results) {
            if (isPrime[result]) answer++;
        }
        
        return answer;
    }
    
    private Set<Integer> makeNums(String[] digits) {
        Set<Integer> result = new HashSet<>();
        for (int len = 1; len <= digits.length; len++) {
            boolean[] used = new boolean[digits.length];
            backtrack(digits, used, "", len, result);
        }
        
        return result;
    }
    
    private void backtrack(String[] digits, boolean[] used, String current, int targetLength, Set<Integer> result) {
        if (current.length() == targetLength) {
            result.add(Integer.parseInt(current));
            return;
        }
        
        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(digits, used, current + digits[i], targetLength, result);
                used[i] = false;
            }
        }
    }
 
    private void sieve(boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(isPrime.length - 1); i++) {
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }
    }
}