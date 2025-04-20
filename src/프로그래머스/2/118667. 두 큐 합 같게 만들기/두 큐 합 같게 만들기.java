import java.util.Arrays;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] arr = new int[queue1.length + queue2.length];
        System.arraycopy(queue1, 0, arr, 0, queue1.length);
        System.arraycopy(queue2, 0, arr, queue1.length, queue2.length);
        int answer = 0;
        int i = 0;
        int j = queue1.length;
        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = (long) Arrays.stream(queue2).asLongStream().sum();
        int limit = queue1.length * 3;
        
        while (answer <= limit) {
            if (sum1 == sum2) return answer;
            
            if (sum1 > sum2) {
                sum1 -= arr[i % arr.length];
                sum2 += arr[i % arr.length];
                i++;
            } else {
                sum1 += arr[j % arr.length];
                sum2 -= arr[j % arr.length];
                j++;
            }
            answer++;
        }
        
        return -1;
    }
}