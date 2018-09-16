/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA, tmpB = headB;
        int lenA = 0, lenB = 0;
        while (tmpA != null) {
            lenA++;
            tmpA = tmpA.next;
        }
        while (tmpB != null) {
            lenB++;
            tmpB = tmpB.next;
        }
        tmpA = headA;
        tmpB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) tmpA = tmpA.next;
        } else {
            for (int i = 0; i < lenB - lenA; i++) tmpB = tmpB.next;
        }
        while (tmpA != null && tmpB != null) {
            if (tmpA == tmpB) {
                return tmpA;
            }
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return null;
    }
}