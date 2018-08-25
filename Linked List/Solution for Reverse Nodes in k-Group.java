/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
//     method 1
//     public ListNode reverseKGroup(ListNode head, int k) {
//         int accum = 0;
//         ListNode start = head, root = new ListNode(0), prev = root;
//         while (head != null) {
//             accum++;
//             if (accum == k) {
//                 head = head.next;
//                 prev.next = reverse(start, k);
//                 start.next = head;
//                 prev = start;
//                 start = head;
//                 accum = 0;
//             } else {
//                 head = head.next;
//             }
//         }
//         prev.next = start;
//         return root.next;
//     }
    
//     private ListNode reverse(ListNode root, int k) {
//         int accum = 0;
//         ListNode prev = null, cur = root;
//         while (accum < k) {
//             accum++;
//             ListNode nextTemp = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = nextTemp;
//         }
//         return prev;
//     }
    
    // method 2
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int accum = 0;
        while (cur != null && accum != k) {
            accum++;
            cur = cur.next;
        }
        if (accum == k) {
            cur = reverseKGroup(cur, k);
            while (accum-- != 0) {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }
}