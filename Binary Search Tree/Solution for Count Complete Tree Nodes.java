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
    public int countNodes(TreeNode root) {
        int[] count = new int[1];
        inorder(root, count);
        return count[0];
    }
    
    private void inorder(TreeNode node, int[] count) {
        if (node == null) return;
        inorder(node.left, count);
        count[0]++;
        inorder(node.right, count);
    }
}