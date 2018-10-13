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
    public int maxDepth(TreeNode root) {
        return depthHelper(root);
    }
    
    private int depthHelper(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depthHelper(node.left), depthHelper(node.right)) + 1;
    }
}