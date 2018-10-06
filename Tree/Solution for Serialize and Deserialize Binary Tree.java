/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildTree(root, sb);
        return sb.toString();
    }
    
    private void buildTree(TreeNode node, StringBuilder sb) {
        if (node == null) sb.append('*').append(' ');
        else {
            sb.append(node.val).append(' ');
            buildTree(node.left, sb);
            buildTree(node.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>(Arrays.asList(data.split(" ")));
        return treeHelper(q);
    }
    
    private TreeNode treeHelper(Deque<String> q) {
        String curval = q.remove();
        if (curval.equals("*")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(curval));
        node.left = treeHelper(q);
        node.right = treeHelper(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));