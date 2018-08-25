/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // method 1
        ListNode first, second, prev = new ListNode(0), root = prev;
        while (head != null) {
            if (head.next != null) {
                first = head;
                second = head.next;
                prev.next = second;
                first.next = second.next;
                second.next = first;
                prev = first;
                head = first.next;
            } else {
                prev.next = head;   
                head = head.next;
            }
        }
        return root.next;
    }
}