import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        ArrayList<String> unionArr = new ArrayList<>();
        ArrayList<String> interSectionArr = new ArrayList<>();
        makeString(str1, unionArr);
        makeString(str2, interSectionArr);

        int cnt = interSectionArr.size();
        for (String s : unionArr) {
            interSectionArr.remove(s);
        }
        if (unionArr.isEmpty() && interSectionArr.isEmpty()) return 65536;
        else {
            cnt -= interSectionArr.size();
            return (int) Math.floor((double) cnt / (unionArr.size() + interSectionArr.size()) * 65536);
        }
    }
    
    private static void makeString(String str, ArrayList<String> arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                sb.setLength(0);
                continue;
            }
            sb.append(Character.toLowerCase(c));
            if (sb.length() == 2) {
                arr.add(sb.toString());
                sb.deleteCharAt(0);
            }
        }
    }
}