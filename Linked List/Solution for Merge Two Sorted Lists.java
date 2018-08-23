/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pl = new ListNode(0), root = pl;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pl.next = new ListNode(l1.val);
                l1 = l1.next;
                pl = pl.next;
            }
            else {
                pl.next = new ListNode(l2.val);
                l2 = l2.next;
                pl = pl.next;
            }
        }
        if (l1 == null) {
            pl.next = l2;
        } else {
            pl.next = l1;
        }
        return root.next;
    }
}