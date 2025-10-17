import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int[] truePerson = new int[p];
        for (int i = 0; i < p; i++) truePerson[i] = Integer.parseInt(st.nextToken());

        List<Set<Integer>> person = new ArrayList<>();
        for (int i = 0; i <= n; i++) person.add(new HashSet<>());

        List<List<Integer>> party = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            party.add(new ArrayList<>());
            for (int j = 0; j < q; j++) party.get(i).add(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < q; j++) {
                for (int k = 0; k < q; k++) {
                    if (party.get(i).get(j).equals(party.get(i).get(k))) continue;
                    person.get(party.get(i).get(j)).add(party.get(i).get(k));
                }
            }
        }

        boolean[] visited = new boolean[n + 1];
        Set<Integer> trueSet = new HashSet<>();

        for (int i : truePerson) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.offerLast(i);
            trueSet.add(i);
            visited[i] = true;

            while (!stack.isEmpty()) {
                int current = stack.pollLast();

                for (int next : person.get(current)) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    trueSet.add(next);
                    stack.offerLast(next);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> members = party.get(i);
            boolean flag = false;
            for (int member : members) {
                if (trueSet.contains(member)) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}