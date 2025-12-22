class Solution {
    public int maxVowels(String s, int k) {
        int cnt = 0;
        int answer = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Deque<Character> q = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (q.size() == k) {
                char c = q.pollFirst();
                if (vowels.contains(c)) cnt--;
            }
            q.offerLast(ch);
            if (vowels.contains(ch)) {
                cnt++;
                if (cnt == k) return k;
                answer = Math.max(answer, cnt);
                continue;
            }
        }

        return answer;
    }
}