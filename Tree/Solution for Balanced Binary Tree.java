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
    
    public boolean isBalanced(TreeNode root) {
        boolean[] flag = new boolean[1];
        flag[0] = true;
        traverse(root, flag);
        return flag[0];
    }
    
    private int traverse(TreeNode node, boolean[] flag) {
        if (node == null) return 0;
        int left = traverse(node.left, flag);
        if (!flag[0]) return -1;
        int right = traverse(node.right, flag);
        if (!flag[0]) return -1;
        if (Math.abs(left - right) > 1) flag[0] = false;
        return Math.max(left, right) + 1;
    }
}