/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = new ListNode(0), cur = head, pre = ptr;
        ptr.next = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            if (pre.next == cur) pre = cur;
            else pre.next = cur.next;
            cur = cur.next;
        }
        return ptr.next;
    }
}