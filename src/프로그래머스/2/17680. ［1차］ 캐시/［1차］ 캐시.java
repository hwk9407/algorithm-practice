import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(32, 0.75f, true);
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.containsKey(city)) {
                answer++;
            } else {
                answer += 5;
            }
            
            cache.put(city, 1);
            if (cache.size() > cacheSize) {
                Iterator<String> it = cache.keySet().iterator();
                it.next();
                it.remove();
            }
        }
        
        return answer;
    }
}