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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            Q.offer(null);
            List<Integer> ele = new ArrayList<>();
            TreeNode tmp = Q.poll();
            do {
                if (tmp.left != null) Q.offer(tmp.left);
                if (tmp.right != null) Q.offer(tmp.right);
                ele.add(tmp.val);
                tmp = Q.poll();
            } while (tmp != null);
            result.add(ele);
        }
        return result;
    }
}