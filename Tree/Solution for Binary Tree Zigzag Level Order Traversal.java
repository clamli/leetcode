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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        boolean flag = true;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = Q.poll();
                if (cur.left != null) Q.offer(cur.left);
                if (cur.right != null) Q.offer(cur.right);
                if (flag) {
                    level.add(cur.val);
                } else {
                    level.add(0, cur.val);
                }
            }
            result.add(level);
            flag = !flag;
        }
        return result;
    }
}