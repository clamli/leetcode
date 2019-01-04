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
        preorder(root, null);
    }
    
    private void preorder(TreeLinkNode node, TreeLinkNode pre) {
        if (node == null) return;
        if (pre != null) {
            if (node == pre.left) node.next = pre.right;
            else if (node == pre.right && pre.next != null) node.next = pre.next.left;
        } else {
            node.next = null;
        }
        preorder(node.left, node);
        preorder(node.right, node);
    }
}