/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // method 1: hashtable
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     Map<Integer, ListNode> map = new HashMap<>();
    //     int idx = 0;
    //     ListNode node = head;
    //     while (node != null) {
    //         map.put(idx++, node);
    //         node = node.next;
    //     }
    //     int front = idx-n-1, end = idx-n+1;
    //     if (!map.containsKey(front) && !map.containsKey(end)) head = null;
    //     else if (!map.containsKey(front)) head = map.get(end);
    //     else if (!map.containsKey(end)) map.get(front).next = null;
    //     else map.get(front).next = map.get(end);
    //     return head;
    // }
    
    // method 2: point to n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int intv = 0;
        ListNode node = head, pointToN = head;
        while (node.next != null) {
            intv++;
            node = node.next;
            if (intv > n) {
                pointToN = pointToN.next;
            }
        }
        if (intv+1 == n) return head.next;
        else pointToN.next = pointToN.next.next;
        return head;
    }
}