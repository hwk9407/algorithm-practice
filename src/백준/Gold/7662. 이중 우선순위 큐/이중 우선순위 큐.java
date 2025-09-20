import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> countMap = new HashMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    maxHeap.offer(n);
                    minHeap.offer(n);
                    countMap.put(n, countMap.getOrDefault(n, 0) + 1);
                } else if (command.equals("D")) {
                    if (n == 1) {
                        while (!maxHeap.isEmpty()) {
                            Integer key = maxHeap.poll();
                            if (countMap.get(key) > 0) {
                                countMap.put(key, countMap.get(key) - 1);
                                break;
                            }
                        }
                    }
                    else if (n == -1) {
                        while (!minHeap.isEmpty()) {
                            Integer key = minHeap.poll();
                            if (countMap.get(key) > 0) {
                                countMap.put(key, countMap.get(key) - 1);
                                break;
                            }
                        }
                    }
                }
            }
            Integer min = null;
            while (!minHeap.isEmpty()) {
                int key = minHeap.poll();
                if (countMap.get(key) > 0) {
                    min = key;
                    break;
                }
            }
            Integer max = null;
            while (!maxHeap.isEmpty()) {
                Integer key = maxHeap.poll();
                if (countMap.get(key) > 0) {
                    max = key;
                    break;
                }
            }
            String result = "";
            if (min == null || max == null) result = "EMPTY";
            else result = max + " " + min;
            System.out.println(result);
        }
    }
}
