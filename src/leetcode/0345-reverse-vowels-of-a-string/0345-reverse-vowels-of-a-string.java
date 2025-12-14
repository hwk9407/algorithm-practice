class Solution {
    public String reverseVowels(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                stack.offerLast(s.charAt(i));
                idx.add(i);
            }
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < idx.size(); i++) {
            arr[idx.get(i)] = stack.pollLast();
        }
        return String.valueOf(arr);
    }
}