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
        if (head == null) return head;
        ListNode pre = head, tmp = head.next;
        while (tmp != null) {
            if (tmp.val == pre.val) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return head;
    }
}