/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode partition(ListNode head, int x) {
    //     ListNode root = new ListNode(0), tmp = root;
    //     root.next = head;
    //     while (tmp.next != null) {
    //         if (tmp.next.val >= x) break;
    //         tmp = tmp.next;
    //     }
    //     if (tmp.next == null) return head;
    //     ListNode start = tmp;
    //     while (tmp.next != null) {
    //         if (tmp.next.val < x) {
    //             ListNode remove = tmp.next;
    //             tmp.next = tmp.next.next;
    //             remove.next = start.next;
    //             start.next = remove;
    //             start = start.next;
    //         } else {
    //             tmp = tmp.next;
    //         }
    //     }
    //     return root.next;
    // }
    
    
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode large = new ListNode(0), lp = large;
        ListNode small = new ListNode(0), sp = small;
        while (head != null) {
            if (head.val < x) {
                sp.next = head;
                sp = sp.next;
                head = head.next;
            } else {
                lp.next = head;
                lp = lp.next;
                head = head.next;
            }
        }
        if (lp.next != null) lp.next = null;
        sp.next = large.next;
        return small.next;
    }
}