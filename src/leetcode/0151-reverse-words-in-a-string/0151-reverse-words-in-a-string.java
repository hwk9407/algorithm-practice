import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        Collections.reverse(list);
        System.out.println(list);

        return String.join(" ", list);
    }
}