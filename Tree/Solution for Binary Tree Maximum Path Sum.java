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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxSideSum(root, max);
        return max[0];
    }
    
    private int maxSideSum(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = maxSideSum(node.left, max);
        int right = maxSideSum(node.right, max);
        max[0] = Math.max(max[0], left + right + node.val);
        int submax = Math.max(0, Math.max(left + node.val, right + node.val));
        return submax;
    }
    
    
}