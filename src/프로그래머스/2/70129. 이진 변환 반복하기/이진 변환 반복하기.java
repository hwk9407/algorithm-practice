class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;
        
        while (s.length() > 1) {
            for (char c : s.toCharArray()) {
                if (c == '0') zeroCount++;
            }
            int size = s.replace("0", "").length();
            s = Integer.toBinaryString(size);
            count++;
        }
        
        
        int[] answer = {count, zeroCount};
        return answer;
    }
}