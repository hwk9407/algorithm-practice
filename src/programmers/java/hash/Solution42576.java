package programmers.java.hash;

import java.util.HashMap;
import java.util.Map;

class Solution42576 {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        for (Map.Entry<String, Integer> s : map.entrySet()) {
            if (s.getValue() == 1) {
                return s.getKey();
            }
        }


        return "";
    }

    public static void main(String[] args) {
        Solution42576 sol = new Solution42576();
        System.out.println(sol.solution(new String[] { "leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
    }
}