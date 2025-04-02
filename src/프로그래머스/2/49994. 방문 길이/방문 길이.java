import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashMap<List<Integer>, Set<List<Integer>>> map = new HashMap<>();

        int[] current = {0, 0};
        for (char direction : dirs.toCharArray()) {
            int[] after = move(current, direction);

            if (Arrays.equals(current, after)) continue;

            List<Integer> from = Arrays.asList(current[0], current[1]);
            List<Integer> to = Arrays.asList(after[0], after[1]);

            map.putIfAbsent(from, new HashSet<>());
            map.putIfAbsent(to, new HashSet<>());

            map.get(from).add(to);
            map.get(to).add(from);

            current = after;
        }

        int answer = map.values().stream().mapToInt(Set::size).sum() / 2;
        return answer;
    }
    
    private int[] move(int[] current, char direction) {
        int[] next = Arrays.copyOf(current, current.length);
        switch (direction) {
            case 'L' -> next[0]--;
            case 'R' -> next[0]++;
            case 'U' -> next[1]++;
            case 'D' -> next[1]--;
        }
        return (Math.abs(next[0]) > 5 || Math.abs(next[1]) > 5) ? current : next;
    }
}