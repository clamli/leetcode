/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public TreeNode sortedListToBST(ListNode head) {
    //     List<Integer> list = new ArrayList<>();
    //     while (head != null) {
    //         list.add(head.val);
    //         head = head.next;
    //     }
    //     return build(list, 0, list.size()-1);
    // }
    // private TreeNode build(List<Integer> list, int start, int end) {
    //     if (start > end) return null;
    //     int mid = start + (end - start + 1) / 2;
    //     TreeNode node = new TreeNode(list.get(mid));
    //     node.left = build(list, start, mid-1);
    //     node.right = build(list, mid+1, end);
    //     return node;
    // }
    
    
    
    ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        this.head = head;
        while (head != null) {
            length++;
            head = head.next;
        }
        return inorder(length);
    }
    
    private TreeNode inorder(int length) {
        if (length == 0) return null;
        if (length == 1) {
            TreeNode root = new TreeNode(head.val);
            head = head.next;
            return root;
        }
        int mid = length / 2;
        TreeNode left = inorder(mid);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = inorder(length-mid-1);
        root.left = left;
        root.right = right;
        return root;
    }
    
    
}