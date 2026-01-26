/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode answer = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        
        head = answer;
        if (n == 1) return null;
        for (int i = 1; i < n / 2; i++) {
            head = head.next;
        }
        head.next = head.next.next;

        return answer;
    }
}