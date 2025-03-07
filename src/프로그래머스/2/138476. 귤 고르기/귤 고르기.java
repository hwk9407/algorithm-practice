import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : tangerine) {
            int num = map.getOrDefault(n, 0);
            map.put(n, ++num);
        }

        List<Integer> arr = new ArrayList<>(map.values());
        arr.sort(Comparator.reverseOrder());
        
        int answer = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (k <= 0) break;
            k -= arr.get(i);
            answer++;
        }
        
        return answer;
    }
}