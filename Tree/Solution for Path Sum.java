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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return preorder(root, sum, 0);
    }
    
    private boolean preorder(TreeNode node, int sum, int cur) {
        cur += node.val;
        if (cur == sum && node.left == null && node.right == null) return true;
        boolean flag = false;
        if (node.left != null) flag = preorder(node.left, sum, cur);
        if (flag) return true;
        if (node.right != null) flag = preorder(node.right, sum, cur);
        return flag;
    }
}