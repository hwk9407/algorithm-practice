class Solution {
    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                deque.pollLast();
                continue;
            }
            deque.offerLast(ch);
        }
        StringBuilder sb = new StringBuilder();
        deque.forEach(sb::append);

        return sb.toString();
    }
}