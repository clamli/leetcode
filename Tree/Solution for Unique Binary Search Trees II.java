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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return createTrees(1, n);
    }
    
    private List<TreeNode> createTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
        } else if (start == end) {
            res.add(new TreeNode(start));
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = createTrees(start, i-1);
                List<TreeNode> right = createTrees(i+1, end);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
} 