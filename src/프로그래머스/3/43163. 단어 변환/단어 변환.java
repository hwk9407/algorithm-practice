import java.util.*;

class Solution {
    private class Node {
        String word;
        int step;
        
        Node (String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(begin, 0));
        visited.add(begin);
        
        while(!queue.isEmpty()) {
            Node current = queue.pollFirst();
            if (current.word.equals(target)) return current.step;
            for (String next : words) {
                if (!visited.contains(next) && isDiffOne(current.word, next)) {
                    visited.add(next);
                    queue.offerLast(new Node(next, current.step + 1));
                }
            }
        }
        return 0;
    }
    
    private boolean isDiffOne(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) == word2.charAt(i)) continue;
            diff++;
        }
        return diff == 1;
    }
}