class Solution {
//     public void solve(char[][] board) {
//         if (board.length == 0) return;
//         int n = board.length, m = board[0].length;
//         boolean[][] isVisited = new boolean[n][m];
//         char[][] tmp = new char[n][m];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 tmp[i][j] = board[i][j];
//             }
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (board[i][j] == 'O' && !isVisited[i][j]) {
//                     if (isSurrounded(board, i, j, n, m, isVisited)) {
//                         dfs(tmp, i, j, n, m);
//                     }
//                 }
//             }
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 board[i][j] = tmp[i][j];
//             }
//         }
//     }
    
//     private boolean isSurrounded(char[][] board, int row, int col, int n, int m, boolean[][] isVisited) {
//         if (row < 0 || col < 0 || row >= n || col >= m) return false;
//         if (isVisited[row][col] || board[row][col] == 'X') return true;
//         isVisited[row][col] = true;
//         boolean flag1 = isSurrounded(board, row+1, col, n, m, isVisited);
//         boolean flag2 = isSurrounded(board, row-1, col, n, m, isVisited);
//         boolean flag3 = isSurrounded(board, row, col+1, n, m, isVisited);
//         boolean flag4 = isSurrounded(board, row, col-1, n, m, isVisited);    
//         return flag1 && flag2 && flag3 && flag4;
//     }
    
//     private void dfs(char[][] board, int row, int col, int n, int m) {
//         if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] == 'X') return;
//         board[row][col] = 'X';
//         dfs(board, row+1, col, n, m);
//         dfs(board, row-1, col, n, m);
//         dfs(board, row, col+1, n, m);
//         dfs(board, row, col-1, n, m);
//     }
    
    
    // 边路突击法
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m-1);
        }
        for (int j = 0; j < m; j++) {
            dfs(board, 0, j);
            dfs(board, n-1, j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = '*';
        dfs(board, row+1, col);
        dfs(board, row-1, col);
        dfs(board, row, col+1);
        dfs(board, row, col-1);
    }
}