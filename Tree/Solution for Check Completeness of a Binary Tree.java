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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();    
        Q.offer(root);
        boolean flag = false;
        while (!Q.isEmpty()) {
            TreeNode tmp = Q.poll();
            if (tmp == null) {
                flag = true;
            } else {
                if (flag) return false;
                Q.offer(tmp.left);
                Q.offer(tmp.right);
            }
        }
        return true;
    }
}