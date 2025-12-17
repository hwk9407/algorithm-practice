class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;

        int i = 0, j = 0;
        while (i < s.length()) {
            boolean flag = false;
            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j++)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
            i++;
        }
        return true;
    }
}