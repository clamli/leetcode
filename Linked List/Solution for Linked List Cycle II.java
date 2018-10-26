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
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        do {
            if (p1 == null || p2 == null || p2.next == null) break;
            p1 = p1.next;
            p2 = p2.next.next;
        } while (p1 != p2);
        if (p1 == null || p2 == null || p2.next == null) return null;
        ListNode start = p1;
        while (start != head) {
            start = start.next;
            head = head.next;
        }
        return start;
    }
}