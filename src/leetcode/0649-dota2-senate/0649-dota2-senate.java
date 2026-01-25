class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new ArrayDeque<>();
        Queue<Integer> dQueue = new ArrayDeque<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') rQueue.offer(i);
            else dQueue.offer(i);
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();
            if (r < d) rQueue.offer(n++);
            else dQueue.offer(n++);
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}