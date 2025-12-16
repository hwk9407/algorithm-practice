class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        char last = ' ';
        int repeat = 0;
        for (char ch : chars) {
            if (ch == last) {
                repeat++;
                continue;
            }

            if (repeat > 1) {
                String digit = String.valueOf(repeat);
                for (char c : digit.toCharArray()) {
                    chars[idx++] = c;
                }
            }
            chars[idx++] = ch;
            repeat = 1;
            last = ch;
        }

        if (repeat > 1) {
            String digit = String.valueOf(repeat);
            for (char c : digit.toCharArray()) {
                chars[idx++] = c;
            }
        }

        return idx;
    }
}