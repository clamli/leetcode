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
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    // }
    // private TreeNode build(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
    //     if (s1 > e1) return null;
    //     TreeNode root = new TreeNode(preorder[s1]);
    //     int i = s2;
    //     for (; i <= e2; i++) {
    //         if (inorder[i] == preorder[s1]) break;
    //     }
    //     int split = s1 + i - s2;
    //     root.left = build(preorder, inorder, s1+1, split, s2, i-1);
    //     root.right = build(preorder, inorder, split+1, e1, i+1, e2);
    //     return root;
    // }
    
    int po = 0;
    int io = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, null);
    }
    private TreeNode build(int[] preorder, int[] inorder, TreeNode prenode) {
        if (po >= preorder.length || (prenode != null && inorder[io] == prenode.val)) return null;
        TreeNode root = new TreeNode(preorder[po++]);
        root.left = build(preorder, inorder, root);
        io++;
        root.right = build(preorder, inorder, prenode);
        return root;
    }
}