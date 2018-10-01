/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode turtle = head, rabbit = head;
        do {
            if (turtle == null || rabbit == null || rabbit.next == null) return false;
            turtle = turtle.next;
            rabbit = rabbit.next.next;
        } while (turtle != rabbit);
        return true;
    }
}