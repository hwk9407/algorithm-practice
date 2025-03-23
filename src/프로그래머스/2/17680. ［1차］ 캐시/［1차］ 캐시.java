import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedHashSet<String> set = new LinkedHashSet<>(cacheSize);
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (set.contains(city)) {
                answer++;
            } else {
                answer += 5;
            }
            
            boolean flag = set.add(city);
            if (set.size() > cacheSize) {
                Iterator<String> it = set.iterator();
                it.next();
                it.remove();
            }
            if (!flag) {
                set.remove(city);
                set.add(city);
            }
        }
        
        return answer;
    }
}