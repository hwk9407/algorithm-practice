import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = 0; j < elements.length; j++) {
                int idx = (i + j) % elements.length;
                sum += elements[idx];
                sumSet.add(sum);
            }
        }
        return sumSet.size();
    }
}