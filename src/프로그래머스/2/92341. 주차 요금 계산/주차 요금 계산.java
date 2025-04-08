import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkedCar = new HashMap<>();
        Map<String, Integer> parkTotal = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            if (split[2].equals("IN")) {
                parkedCar.put(split[1], convertTime(split[0]));
            } else if (split[2].equals("OUT")) {
                int time = parkTotal.getOrDefault(split[1], 0) + convertTime(split[0]) - parkedCar.get(split[1]);
                parkedCar.remove(split[1]);
                parkTotal.put(split[1], time);
            }
        }

        for (Map.Entry<String, Integer> entry : parkedCar.entrySet()) {
            int time = parkTotal.getOrDefault(entry.getKey(), 0) + convertTime("23:59") - entry.getValue();
            parkTotal.put(entry.getKey(), time);
        }

        List<String> keySet = new ArrayList<>(parkTotal.keySet());
        keySet.sort(Comparator.naturalOrder());
        int[] answer = keySet.stream().mapToInt(parkTotal::get).map(time -> calculate(time, fees)).toArray();
        return answer;
    }

    private int convertTime(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    private int calculate(int time, int[] fees) {
        if (time <= fees[0]) return fees[1];
        return fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
    }
}