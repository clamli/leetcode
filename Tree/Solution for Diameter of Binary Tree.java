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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        maxDiameter(root, max);
        return max[0];
    }
    
    private int maxDiameter(TreeNode node, int[] max) {
        if (node == null) return -1;
        int left = maxDiameter(node.left, max) + 1;
        int right = maxDiameter(node.right, max) + 1;
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right);
    } 
}