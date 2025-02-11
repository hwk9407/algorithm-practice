package programmers.java.hash;


import java.util.Collections;
import java.util.HashSet;

class Solution42577 {

    public boolean solution(String[] phone_book) {
        HashSet<String> phoneSet = new HashSet<>();
        Collections.addAll(phoneSet, phone_book);

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (phoneSet.contains(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution42577 sol = new Solution42577();
        System.out.println(sol.solution(new String[]{"11", "12", "111"}));
    }
}