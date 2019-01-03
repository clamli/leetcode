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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        preorder(root, sum, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void preorder(TreeNode node, int sum, int cur, List<Integer> curList, List<List<Integer>> results) {
        cur += node.val;
        curList.add(node.val);
        if (cur == sum && node.left == null && node.right == null) {
            results.add(curList);
            return;
        }
        if (node.left != null) preorder(node.left, sum, cur, new ArrayList<>(curList), results);
        if (node.right != null) preorder(node.right, sum, cur, new ArrayList<>(curList), results);
    }
}