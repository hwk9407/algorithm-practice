import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        String[] startTime = new String[book_time.length];
        String[] endTime = new String[book_time.length];
        for (int i = 0; i < book_time.length; i++) {
            String[] time = book_time[i];
            startTime[i] = time[0];
            endTime[i] = addTenMinute(time[1]);
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        
        int answer = 0;
        int enterIdx = 0;
        int exitIdx = 0;
        int current = 0;
        while (enterIdx < startTime.length) {
            if (startTime[enterIdx].compareTo(endTime[exitIdx]) >= 0) {
                current--;
                exitIdx++;
            } else {
                current++;
                answer = Math.max(answer, current);
                enterIdx++;
            }
        }
        
        return answer;
    }
    
    private String addTenMinute(String time) {
        String[] split = time.split(":");
        int minute = Integer.parseInt(split[1]) + 10;
        int hour = Integer.parseInt(split[0]);
        if (minute >= 60) {
            hour++;
            minute -= 60;
        }
        String minuteStr = minute < 10 ? 0 + String.valueOf(minute) : String.valueOf(minute);
        String hourStr = hour < 10 ? 0 + String.valueOf(hour) : String.valueOf(hour);
        
        return hourStr + ":" + minuteStr;
    }
}