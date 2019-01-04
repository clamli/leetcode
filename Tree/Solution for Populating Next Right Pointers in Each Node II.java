/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while (head != null) {
            head = linkNextLevel(head);
        }
    }
    
    private TreeLinkNode linkNextLevel(TreeLinkNode head) {
        TreeLinkNode curLevel = new TreeLinkNode(-1), tmp = curLevel;
        while (head != null) {
            if (head.left == null && head.right == null) {
                head = head.next;
            } else {
                break;
            }
        }
        while (head != null) {
            if (head.left != null) {
                tmp.next = head.left;
                tmp = tmp.next;
            } 
            if (head.right != null) {
                tmp.next = head.right;
                tmp = tmp.next;
            }
            head = head.next;
        }
        return curLevel.next;
    }
}