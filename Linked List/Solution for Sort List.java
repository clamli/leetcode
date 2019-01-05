/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode sortList(ListNode head) {
        ListNode head1 = head, head2 = head, pre = null;
        while (head2 != null && head2.next != null) {
            pre = head1;
            head1 = head1.next;
            head2 = head2.next.next;
        }
        if (pre == null) return head;
        pre.next = null;
        head = sortList(head);
        head1 = sortList(head1);
        head = merge(head, head1);
        return head;
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode h = new ListNode(-1), res = h;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                h.next = h1;
                h1 = h1.next;
            } else {
                h.next = h2;
                h2 = h2.next;
            }
            h = h.next;            
        }
        if (h1 != null) {
            h.next = h1;
        } else {
            h.next = h2;
        }
        return res.next;
    }
}