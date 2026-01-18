class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();

        int tempNum = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                tempNum = tempNum * 10 + (c - '0');
            } else if (c == '[') {
                numStack.offerLast(tempNum);
                strStack.offerLast(sb.toString());
                sb.setLength(0);
                tempNum = 0;
            } else if (c == ']') {
                String str = strStack.pollLast();
                int repeat = numStack.pollLast();

                String result = sb.toString().repeat(repeat);
                sb.setLength(0);
                sb.append(str).append(result);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}