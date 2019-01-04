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
    
    private List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        preorder(root, 0);
        Collections.reverse(results);
        return results;
    }
    
    private void preorder(TreeNode node, int level) {
        if (node == null) return;
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(node.val);
        preorder(node.left, level+1);
        preorder(node.right, level+1);
    }
}