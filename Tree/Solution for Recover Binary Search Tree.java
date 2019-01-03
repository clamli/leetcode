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
    // public void recoverTree(TreeNode root) {
    //     TreeNode node1 = null, node2 = null, pre = null, node = root;
    //     Stack<TreeNode> S = new Stack<>();
    //     while (node != null || !S.isEmpty()) {
    //         while (node != null) {
    //             S.push(node);
    //             node = node.left;
    //         }
    //         node = S.pop();
    //         if (pre != null && pre.val > node.val) {
    //             if (node1 == null) {
    //                 node1 = pre;
    //                 node2 = node;
    //             }
    //             else node2 = node;
    //         }
    //         pre = node;
    //         node = node.right;
    //     }
    //     int tmp = node1.val;
    //     node1.val = node2.val;
    //     node2.val = tmp;
    // }
    
    private TreeNode x1 = null, x2 = null, pre = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = x1.val;
        x1.val = x2.val;
        x2.val = tmp;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (pre != null && pre.val > node.val) {
            if (x1 == null) {
                x1 = pre;
                x2 = node;
            } else {
                x2 = node;
            }
        }
        pre = node;
        inorder(node.right);
    }
    
    
}