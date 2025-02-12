package programmers.java.hash;

import java.util.*;

class Solution42579 {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Pair pair = new Pair(i, plays[i]);
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(pair);
        }
        for (String key : map.keySet()) {
            List<Pair> pairs = map.get(key);
            if (pairs.size() > 1) {
                pairs.sort(Pair::compareTo);
            }
        }
       return map.values()
                .stream()
                .sorted(Comparator.comparingLong(this::getGenreSum))
                .map(pairs -> pairs.size() > 1 ? pairs.subList(0, 2) : pairs)
                .flatMap(Collection::stream)
                .mapToInt(Pair::getIdx)
                .toArray();
    }

    public static void main(String[] args) {
        Solution42579 sol = new Solution42579();
        int[] result = sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        Arrays.stream(result).forEach(System.out::println);
    }

    private class Pair implements Comparable<Pair> {
        private final int idx;
        private final long value;

        private Pair(int idx, long value) {
            this.idx = idx;
            this.value = value;
        }

        public int getIdx() {
            return idx;
        }

        public long getValue() {
            return value;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.value, o.value) * -1; // 내림차순
        }
    }

    private long getGenreSum (List<Pair> pairs) {
        return pairs.stream()
                .mapToLong(Pair::getValue)
                .sum() * -1; // 장르 합계 내림차순
    }
}