import java.util.*;
import java.io.*;

public class Main {
    private static class Person {
        int weight;
        int height;

        Person (int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] person = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            person[i] = new Person(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        StringBuilder sb = new StringBuilder();
        for (Person p : person) {
            long rank = Arrays.stream(person)
                    .filter(other -> p.weight < other.weight && p.height < other.height)
                    .count() + 1;
            sb.append(rank).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}