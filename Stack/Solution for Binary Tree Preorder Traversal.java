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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> S = new Stack<>();
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        while (node != null || !S.isEmpty()) {
            while (node != null) {
                result.add(node.val);
                S.push(node);
                node = node.left;
            }
            node = S.pop();
            node = node.right;
        }
        return result;
    }
}