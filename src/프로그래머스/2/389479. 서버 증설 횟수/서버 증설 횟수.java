import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> serverTime = new LinkedList<>();
        Queue<Integer> serverCount = new LinkedList<>();
        int totalRent = 0;
        int answer = 0;
        
        for (int time = 0; time < players.length; time++) {
            int player = players[time];
            while (!serverTime.isEmpty() && time - k == serverTime.peek()) {
                serverTime.poll();
                totalRent -= serverCount.poll();
            }
            if ((totalRent + 1) * m <= player) {
                serverTime.offer(time);
                int needServer = (player - (totalRent * m)) / m;
                totalRent += needServer;
                answer += needServer;
                serverCount.offer(needServer);
            }
        }
        
        return answer;
    }
}