class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int i = 0, j = 0;
        while(i < ch1.length && j < ch2.length) {
            sb.append(ch1[i++]);
            sb.append(ch2[j++]);
        }
        if (i < ch1.length) sb.append(word1.substring(i));
        else if (j < ch2.length) sb.append(word2.substring(j));

        return sb.toString();
    }
}