import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        
        HashMap<Integer, Integer> frontMap = new HashMap<>();
        HashMap<Integer, Integer> backMap = new HashMap<>();
        frontMap.put(topping[0], 1);
        for (int i = 1; i < topping.length; i++) {
            backMap.put(topping[i], backMap.getOrDefault(topping[i], 0) + 1);
        }
        
        int frontSize = 1;
        int backSize = backMap.size();
        int answer = 0;
        int idx = 1;
        while (frontSize <= backSize && idx < topping.length) {
            if (frontSize == backSize) answer++;
            int a = topping[idx];
            Integer result = frontMap.putIfAbsent(a, 1);
            if (result == null) frontSize++;
            
            result = backMap.get(a) - 1;
            backMap.put(a, result);
            if (result == 0) backSize--;
            idx++;
        }
        
        return answer;
    }
}