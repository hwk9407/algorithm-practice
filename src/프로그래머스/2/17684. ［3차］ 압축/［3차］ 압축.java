import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            String s = Character.toString(('A' + i));
            dict.put(s, i + 1);
        }


        String w = "";
        int idx = 27;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            String wc = w + c;
            if (dict.containsKey(wc)) {
                w = wc;
            } else {
                list.add(dict.get(w));
                dict.put(wc, idx++);
                w = String.valueOf(c);
            }
        }

        // 마지막 문자열 처리
        if (!w.isEmpty()) {
            list.add(dict.get(w));
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}