import java.util.*;

class Solution {
    private static class Music {
        String title;
        int duration;
        List<String> melody;
        
        Music(String title, int duration, List<String> melody) {
            this.title = title;
            this.duration = duration;
            this.melody = melody;
        }
    }

    public String solution(String m, String[] musicinfos) {
        List<String> heard = parseNotes(m);
        List<Music> matchMusic = new ArrayList<>();
        
        for (String info : musicinfos) {
            String[] parts = info.split(",");
            int duration = toMinutes(parts[1]) - toMinutes(parts[0]);
            String title = parts[2];
            List<String> original = parseNotes(parts[3]);
            List<String> melody = new ArrayList<>();

            for (int i = 0; i < duration; i++) {
                melody.add(original.get(i % original.size()));
            }

            if (isMatch(melody, heard)) {
                matchMusic.add(new Music(title, duration, melody));
            }
        }
        
        String answer = "(None)";
        int maxDuration = -1;
        for (Music music : matchMusic) {
            if (music.duration > maxDuration) {
                maxDuration = music.duration;
                answer = music.title;
            }
        }
        return answer;
    }

    private List<String> parseNotes(String melodies) {
        List<String> melody = new ArrayList<>();
        for (int i = 0; i < melodies.length(); i++) {
            if (i + 1 < melodies.length() && melodies.charAt(i + 1) == '#') {
                melody.add(melodies.charAt(i) + "#");
                i++;
            } else {
                melody.add(melodies.charAt(i) + "");
            }
        }
        return melody;
    }

    private int toMinutes(String time) {
        String[] split = time.split(":");
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
    }
    
    private boolean isMatch(List<String> melody, List<String> heard) {
        for (int i = 0; i <= melody.size() - heard.size(); i++) {
            boolean isEqual = true;
            for (int j = 0; j < heard.size(); j++) {
                if (!melody.get(i + j).equals(heard.get(j))) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) return true;
        }
        return false;
    }
}