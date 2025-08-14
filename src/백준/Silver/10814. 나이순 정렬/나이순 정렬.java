import java.io.*;
import java.util.*;

public class Main {
    public static class Person implements Comparable<Person> {
        private static int IDX = 0;
        int idx;
        int age;
        String name;

        public Person (int age, String name) {
            this.idx = IDX++;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Person p) {
            if (this.age != p.age) return this.age - p.age;
            return this.idx - p.idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] person = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            person[i] = new Person(Integer.parseInt(line[0]), line[1]);
        }
        Arrays.sort(person);
        StringBuilder sb = new StringBuilder();
        for (Person p : person) {
            sb.append(p).append("\n");
        }
        System.out.print(sb);
    }
}