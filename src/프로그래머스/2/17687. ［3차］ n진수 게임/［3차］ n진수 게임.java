class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int num = 0;
        while (cnt < t) {
            for (char c : Integer.toString(num++, n).toCharArray()) {
                if (p == 1) {
                    sb.append(Character.toUpperCase(c));
                    cnt++;
                    if (cnt >= t) break;
                    p = m;
                } else {
                p--;
                }
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}