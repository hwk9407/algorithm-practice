import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 한 번호가 다른 번호의 접두어인 경우 false, 없으면 true
        // phone_book의 최대 크기는 100만 이하이기 때문에, O(N^2)을 넘기면 안됨
        // 같은 번호 중복 안들어가있음
        // 각 전화번호 길이는 20 이하
        // 사전 순으로 오름차순 정렬
        Arrays.sort(phone_book);
        boolean answer = true;
        
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}