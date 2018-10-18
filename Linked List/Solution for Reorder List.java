/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> lst = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            lst.add(tmp);
            tmp = tmp.next;
        }
        int s = 0, e = lst.size()-1;
        while (s < e) {
            lst.get(s).next = lst.get(e);
            lst.get(e).next = lst.get(s+1);
            s++;
            e--;
        }
        lst.get(s).next = null;
    }
}