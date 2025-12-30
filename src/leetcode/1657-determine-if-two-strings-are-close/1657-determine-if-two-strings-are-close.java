class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: word2.toCharArray()) {
            map2.merge(c, 1, Integer::sum);
        }

        // 키 비교
        if (!map1.keySet().equals(map2.keySet())) return false;

        // 값 개수 비교
        List<Integer> list1 = new ArrayList<>(map1.values());
        Collections.sort(list1);

        List<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list2);

        return list1.equals(list2);
    }
}