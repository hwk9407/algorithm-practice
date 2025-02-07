package leetcode.java.Solution876;

import java.util.ArrayList;
import java.util.List;

/**
 * 2025-02-07
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 * 876. Middle of the Linked List
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

    public ListNode middleNode(ListNode head) {
        int nodeSize = 0;
        ListNode current = head;

        while (current != null) {
            nodeSize++;
            current = current.next;
        }

        current = head;
        for (int i = 0; i < nodeSize / 2; i++) {
            current = current.next;
        }

        return current;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode answer = solution.middleNode(head);
        List<Integer> list = new ArrayList<>();
        while (answer != null) {
            list.add(answer.val);
            answer = answer.next;
        }
        System.out.println(list);
    }
}