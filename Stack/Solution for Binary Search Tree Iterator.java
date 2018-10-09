/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> S = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            S.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !S.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode root = S.pop();
        TreeNode root_right = root.right;
        while (root_right != null) {
            S.push(root_right);
            root_right = root_right.left;
        }
        return root.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */