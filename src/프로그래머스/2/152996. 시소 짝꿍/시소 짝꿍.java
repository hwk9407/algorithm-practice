import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        HashMap<Long, Integer> map = new HashMap<>();
        long answer = 0;
        double[] ratio = {1.0, 2.0 / 3, 1.0 / 2, 3.0 / 4};
        
        for (int weight : weights) {
            for (double r : ratio) {
                long key = Math.round(weight * r * 10);
                if (map.containsKey(key)) {
                    answer += map.get(key);
                }
            }
            long key = Math.round(weight * 10);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
            
        return answer;
    }
}