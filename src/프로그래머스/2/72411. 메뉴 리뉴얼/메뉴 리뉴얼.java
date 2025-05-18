import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            for (int size : course) {
                combination(chars, size, 0, new StringBuilder(), countMap);
            }
        }
        
        List<String> resultList = new ArrayList<>();
        for (int size : course) {
            List<String> tempList = new ArrayList<>();
            int maxCount = 2;
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                String key = entry.getKey();
                int count = entry.getValue();
                if (key.length() != size) continue;
                if (count > maxCount) {
                    maxCount = count;
                    tempList.clear();
                    tempList.add(key);
                } else if (count == maxCount) {
                    tempList.add(key);
                }
            }
            resultList.addAll(tempList);
        }
        resultList.sort(Comparator.naturalOrder());
        String[] answer = resultList.toArray(new String[0]);
        
        return answer;
    }
    
    private void combination(char[] chars, int size, int current, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == size) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        for (int i = current; i < chars.length; i++) {
            sb.append(chars[i]);
            combination(chars, size, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}