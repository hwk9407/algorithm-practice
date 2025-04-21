import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> q = new LinkedList<>();
        int[] rest = new int[truckWeights.length];
        Arrays.fill(rest, bridgeLength);
        
        int idx = 0; // 현재 인덱스
        int completeCount = 0; // 완료 트럭 수
        int current = 0; // 현재 총 무게
        int time = 0;
        while(completeCount < truckWeights.length) {
            time++;
            
            for (int i = 0; i < q.size(); i++) {
                rest[i + completeCount]--;
            }
            
            if(rest[completeCount] == 0) {
                current -= q.poll();
                completeCount++;
            }
            
            if (idx < truckWeights.length && current + truckWeights[idx] <= weight) {
                q.add(truckWeights[idx]);
                current += truckWeights[idx];
                idx++;
            }
        }
        
        return time;
    }
}