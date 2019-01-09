class WordDictionary {
    
    TreeNode root;
    
    
    public class TreeNode {
        boolean status;
        TreeNode[] map;
        // Map<Character, TreeNode> map;
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode();
        root.status = false;
        root.map = new TreeNode[26];
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            if (ptr.map[word.charAt(i)-'a'] == null) {
                TreeNode node = new TreeNode();
                node.map = new TreeNode[26];
                ptr.map[word.charAt(i)-'a'] = node;
            }
            ptr = ptr.map[word.charAt(i)-'a'];
        }
        ptr.status = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] target, int start, TreeNode node) {
        if (start == target.length) return node.status;
        if (target[start] != '.') {
            if (node.map[target[start]-'a'] == null) return false;
            return match(target, start+1, node.map[target[start]-'a']);
        } else {
            for (TreeNode next : node.map) {
                if (next != null && match(target, start+1, next)) return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */