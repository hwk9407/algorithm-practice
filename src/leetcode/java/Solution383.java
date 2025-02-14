package leetcode.java;

import java.util.HashMap;

/*
2025-02-14
https://leetcode.com/problems/ransom-note/
383. Ransom Note
두 개의 문자열이 주어진다.
만약 magazine에 의해 ransomNote문자열이 만들어 질 수 있으면 true
없으면 false를 반환해라.
magazine에 있는 글자들은 각각 한번씩만 사용할 수 있다.
 */
class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.getOrDefault(c, 0) <= 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution383 sol = new Solution383();
        System.out.println(sol.canConstruct("aa", "baaa")); // false
    }
}