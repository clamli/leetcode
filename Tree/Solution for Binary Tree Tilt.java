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
    public int findTilt(TreeNode root) {
        int[] res = new int[1];
        traverse(root, res);
        return res[0];
    }
    
    private int traverse(TreeNode node, int[] res) {
        if (node == null) return 0;
        int left = traverse(node.left, res), right = traverse(node.right, res);
        res[0] += Math.abs(left - right);
        return node.val + left + right;
    }
}