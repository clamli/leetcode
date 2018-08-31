/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1;
        ListNode tmp1 = head;
        while (tmp1.next != null) {
            tmp1 = tmp1.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        int pos = len - k;
        ListNode tmp2 = head;
        while (pos > 1) {
            tmp2 = tmp2.next;
            pos--;
        }
        tmp1.next = head;
        head = tmp2.next;
        tmp2.next = null;
        return head;
    }
}