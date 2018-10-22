class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        CharacterTree root = buildTree(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int row, int col, CharacterTree curNode, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#') return;
        curNode = curNode.children[board[row][col]-'a'];
        if (curNode == null) return;
        if (curNode.word != null) {
            result.add(curNode.word);
            curNode.word = null;
        }
        char tmp = board[row][col];
        board[row][col] = '#';
        dfs(board, row+1, col, curNode, result);
        dfs(board, row-1, col, curNode, result);
        dfs(board, row, col+1, curNode, result);
        dfs(board, row, col-1, curNode, result);
        board[row][col] = tmp;
    }
    
    class CharacterTree {
        CharacterTree[] children = new CharacterTree[26];
        String word = null;
    }
    
    private CharacterTree buildTree(String[] words) {
        CharacterTree root = new CharacterTree();
        for (String word : words) {
            CharacterTree p = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (p.children[idx] == null) p.children[idx] = new CharacterTree();
                p = p.children[idx];
            }
            p.word = word;
        }
        return root;
    }
}