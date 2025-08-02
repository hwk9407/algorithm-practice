import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<String> heard = parseNotes(m);
        String answer = "(None)";
        int maxTime = -1;
        for (String info : musicinfos) {
            String[] parts = info.split(",");
            List<String> music = parseNotes(parts[3]);
            int duration = getTime(parts[0], parts[1]);
            
            List<String> played = new ArrayList<>();
            for (int i = 0; i < duration; i++) {
                played.add(music.get(i % music.size()));
            }

            boolean found = false;
            for (int i = 0; i <= played.size() - heard.size(); i++) {
                boolean matched = true;
                for (int j = 0; j < heard.size(); j++) {
                    if (!played.get(i + j).equals(heard.get(j))) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    found = true;
                    break;
                }
            }
            if (found && duration > maxTime) {
                answer = parts[2];
                maxTime = duration;
            }
        }
        return answer;
    }

    private List<String> parseNotes(String melody) {
        List<String> notes = new ArrayList<>();
        for (int i = 0; i < melody.length(); i++) {
            if (i + 1 < melody.length() && melody.charAt(i + 1) == '#') {
                notes.add(melody.charAt(i) + "#");
                i++;
            } else {
                notes.add("" + melody.charAt(i));
            }
        }
        return notes;
    }

    private int getTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        int time = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        time -= Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        return time;
    }
}