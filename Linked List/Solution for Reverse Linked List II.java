/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        int cursor = 1;
        ListNode pre = null, cur = head, start = null, end = null;
        while (cur != null) {
            if (cursor > n) break;
            if (cursor > m) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            } else {
                if (cursor == m) {
                    start = pre;
                    end = cur;
                }
                pre = cur;
                cur = cur.next;
            }
            cursor++;
        }
        if (start != null)
            start.next = pre;
        end.next = cur;
        if (m == 1) head = pre;
        return head;
    }
}