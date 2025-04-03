import java.util.*;

class Solution {
    public int solution(String word) {
        char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
        ArrayList<String> arr = new ArrayList<>();
        
        dfs("", alphabet, arr);
        return arr.indexOf(word) + 1;
    }

    private void dfs(String str, char[] alphabet, ArrayList<String> arr) {
        if (!str.isEmpty()) arr.add(str);
        if (str.length() == 5) return;
        
        for (char c : alphabet) {
            dfs(str + c, alphabet, arr);
        }
    }
}