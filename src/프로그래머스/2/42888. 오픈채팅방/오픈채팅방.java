import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickMap = new HashMap<>();
        int size = 0;
        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            if (action.equals("Enter") || action.equals("Change")) {
                nickMap.put(split[1], split[2]);
            }
            if (!action.equals("Change")) {
                size++;
            }
        }
        
        String[] answer = new String[size];
        int idx = 0;
        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            if (action.equals("Enter")) {
                answer[idx++] = nickMap.get(split[1]) + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                answer[idx++] = nickMap.get(split[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}