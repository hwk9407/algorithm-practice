import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }

        int answer = 0;
        for (String order : skill_trees) {
            int idx = -1;
            boolean flag = false;
            for (char c : order.toCharArray()) {
                Character ch = c;
                int current = map.getOrDefault(ch, -1);
                if (current - idx != 1 && current != -1) {
                    flag = true;
                    break;
                }
                idx = map.getOrDefault(ch, idx);
            }
            if (!flag) answer++;
        }

        return answer;
    }
}