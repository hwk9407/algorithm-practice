import java.util.Stack;

class Solution {
    public int solution(int k, int[][] dungeons) {
        // dungeons의 첫번째 인덱스의 갯수는 1 ~ 8
        // dungeons[최소 필요 피로도, 소모 피로도]
        // 던전에 입장하기 위한 최소 필요 피로도
        // 던전 탐험 후 소모되는 소모 피로도
        // k = 현재 피로도
        // answer = 최대 탐험 가능한 던전 횟수
        int answer = 0;
        Stack<Integer> maxCount = new Stack<>();
        Stack<Integer> stackK = new Stack<>();
        Stack<boolean[]> visited = new Stack<>();
        
        maxCount.push(answer);
        stackK.push(k);
        visited.push(new boolean[dungeons.length]);
        
        while (!stackK.isEmpty()) {
            int current = stackK.pop();
            int count = maxCount.pop();
            boolean[] visitFlag = visited.pop();
            
            answer = Math.max(count, answer);
            
            for (int i = 0; i < dungeons.length; i++) {
                if (!visitFlag[i] && current >= dungeons[i][0]) {
                    visitFlag[i] = true;
                    
                    maxCount.push(count + 1);
                    stackK.push(current - dungeons[i][1]);
                    visited.push(visitFlag.clone());
                    
                    visitFlag[i] = false;
                }
            }
        }
        
        return answer;
    }
}