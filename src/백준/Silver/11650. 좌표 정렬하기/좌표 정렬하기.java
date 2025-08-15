import java.io.*;
import java.util.*;

public class Main {
    private static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x != p.x) return this.x - p.x;
            return this.y - p.y;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Point> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            set.add(new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        StringBuilder sb = new StringBuilder();
        for (Point p : set) {
            sb.append(p).append("\n");
        }
        System.out.print(sb);
    }
}