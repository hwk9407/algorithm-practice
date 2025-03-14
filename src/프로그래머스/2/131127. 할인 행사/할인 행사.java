import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();

        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            for (int a = 0; a < want.length; a++) {
                map.put(want[a], number[a]);
            }

            boolean flag = false;
            for (int j = i; j < i + 10; j++) {
                if (map.getOrDefault(discount[j], 0) == 0) {
                    flag = true;
                    break;
                }
                map.put(discount[j], map.get(discount[j]) - 1);
            }
            if (flag) continue;
            answer++;
        }
        return answer;
    }
}