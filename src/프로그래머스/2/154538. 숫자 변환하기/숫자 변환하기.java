import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        queue.add(new int[]{x, 0});
        visited[x] = true;
        int answer = -1;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int num = arr[0];
            int count = arr[1];

            if (num == y) {
                answer = count;
                break;
            }
            count++;
            if (num * 3 <= y && !visited[num * 3]) {
                visited[num * 3] = true;
                queue.add(new int[]{num * 3, count});
            }
            if (num * 2 <= y && !visited[num * 2]) {
                visited[num * 2] = true;
                queue.add(new int[]{num * 2, count});
            }
            if (num + n <= y && !visited[num + n]) {
                visited[num + n] = true;
                queue.add(new int[]{num + n, count});
            }
        }

        return answer;
    }
}