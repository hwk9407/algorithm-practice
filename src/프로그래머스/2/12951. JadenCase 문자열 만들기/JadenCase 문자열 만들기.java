class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].isBlank()) {
                sb.append(" ");
                continue;
            }
            String word = words[i].toLowerCase();
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            sb.append(word).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}