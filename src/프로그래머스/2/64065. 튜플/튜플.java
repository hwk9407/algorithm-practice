import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 한번에 replaceAll로 정규식을 사용해서 }랑 {를 없앤다.
        // ,를 기준으로 split한다.
        // set에 중복허용하지않고 담고 그걸 int[]에 넣어 반환한다.
        String replaceStr = s.replaceAll("\\{\\{|\\}\\}", "");
        String[] splitStr = replaceStr.split("\\},\\{");
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < splitStr.length; i++) {
            for (String str : splitStr[i].split(",")) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        System.out.println(map);
        
        ArrayList<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        System.out.println(sortedList);
        
        int[] answer = new int[sortedList.size()];
        for (int i = 0; i < sortedList.size(); i++) {
            int num = Integer.parseInt(sortedList.get(i).getKey());
            answer[i] = num;
        }
        return answer;
    }
}