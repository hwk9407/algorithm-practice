package programmers.java.hash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution42578 {

    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] arr : clothes) {
            map.computeIfAbsent(arr[1], s -> new ArrayList<>()).add(arr[0]);
        }

        int result = 1;
        for (String s : map.keySet()) {
            result *= map.get(s).size() + 1;
        }
        return result - 1;
    }

    public static void main(String[] args) {
        Solution42578 sol = new Solution42578();
        System.out.println(sol.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));

    }
}