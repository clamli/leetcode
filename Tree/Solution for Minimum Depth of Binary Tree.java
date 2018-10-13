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
    public int minDepth(TreeNode root) {
        return depthHelper(root);
    }
    
    private int depthHelper(TreeNode node) {
        if (node == null) return 0;
        int left = depthHelper(node.left), right = depthHelper(node.right);
        if (left != 0 && right != 0) {
            return Math.min(left, right) + 1;
        } else if (left == 0) {
            return right + 1;
        } else {
            return left + 1;
        }
    }
}