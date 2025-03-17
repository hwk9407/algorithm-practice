import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] arr : clothes) {
            map.computeIfAbsent(arr[1], s -> new ArrayList<>()).add(arr[0]);
        }
        System.out.println(map);

        int result = 1;
        for (String s : map.keySet()) {
            result *= map.get(s).size() + 1;
        }
        return result - 1;
    }
}