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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        traverse(root, 0, res);
        return res[0];
    }
    
    private void traverse(TreeNode node, int curSum, int[] res) {
        curSum = curSum*10 + node.val;
        if (node.left == null && node.right == null) res[0] += curSum;
        if (node.left != null) traverse(node.left, curSum, res);
        if (node.right != null) traverse(node.right, curSum, res);
    }
}