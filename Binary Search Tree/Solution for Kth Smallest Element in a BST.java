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
    // public int kthSmallest(TreeNode root, int k) {
    //     int val = 0;
    //     Stack<TreeNode> S = new Stack();
    //     TreeNode node = root;
    //     while (node != null || !S.isEmpty()) {
    //         while (node != null) {
    //             S.push(node);
    //             node = node.left;
    //         }
    //         node = S.pop();
    //         k--;
    //         if (k == 0) {
    //             val = node.val;
    //             break;
    //         }
    //         node = node.right;          
    //     }
    //     return val;
    // }
    
    int pk;
    
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        pk = k;
        inorder(root, res);
        return res[0];
    }
    
    private void inorder(TreeNode node, int[] res) {
        if (pk == 0 || node == null) return;
        inorder(node.left, res);
        if (pk == 0) return;
        pk--;
        if (pk == 0) {
            res[0] = node.val; 
            return;
        }
        inorder(node.right, res);
    }
}