import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            fileArr[i] = new File(files[i], i);
        }
        Arrays.sort(fileArr);

        String[] answer = Arrays.stream(fileArr).map(file -> file.name).toArray(String[]::new);
        return answer;
    }
    
    class File implements Comparable<File> {
        String name;
        int index;
        String head;
        int number;

        public File(String file, int index) {
            int i = 0;
            while (i < file.length() && !Character.isDigit(file.charAt(i))) {
                i++;
            }
            int j = i;
            while (j < file.length() && Character.isDigit(file.charAt(j))) {
                j++;
            }

            this.name = file;
            this.index = index;
            this.head = file.substring(0, i).toLowerCase();
            this.number = Integer.parseInt(file.substring(i, j));
        }

        @Override
        public int compareTo(File o) {
            if (!this.head.equals(o.head)) return this.head.compareTo(o.head);
            if (this.number != o.number) return Integer.compare(this.number, o.number);
            return this.index > o.index ? 1 : -1;
        }
    }
}