import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            boolean flag = set.add(words[i]);
            boolean isNotValid = (i != 0 && words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1));
            if (!flag || isNotValid) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
}