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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> S = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (root != null || !S.isEmpty()) {
            while (root != null) {
                S.push(root);
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            TreeNode tmp = S.pop();
            result.add(tmp.val);
            if (!S.isEmpty() && S.peek().left == tmp) root = S.peek().right;
        }
        return result;
    }
}