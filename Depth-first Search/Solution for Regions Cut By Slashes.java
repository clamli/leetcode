class Solution {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length, size = N*3 + 2;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][0] = 1;
            matrix[i][size-1] = 1;
        }
        for (int j = 0; j < size; j++) {
            matrix[0][j] = 1;
            matrix[size-1][j] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '/') {
                    left(matrix, i, j);
                } else if (grid[i].charAt(j) == '\\') {
                    right(matrix, i, j);
                }
            }
        }
        return countIsland(matrix);
    }
    
    private void left(int[][] matrix, int row, int col) {
        int str = row * 3+1, stc = col * 3+3;
        matrix[str][stc] = 1;
        matrix[str+1][stc-1] = 1;
        matrix[str+2][stc-2] = 1;
    }
    
    private void right(int[][] matrix, int row, int col) {
        int str = row * 3+1, stc = col * 3+1;
        matrix[str][stc] = 1;
        matrix[str+1][stc+1] = 1;
        matrix[str+2][stc+2] = 1;
    }
    
    private int countIsland(int[][] matrix) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    cnt++;
                    dfs(matrix, i, j);                    
                }
            }
        }
        return cnt;
    }
    
    private void dfs(int[][] matrix, int row, int col) {
        if (row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0 || matrix[row][col] == 1) return;
        matrix[row][col] = 1;
        dfs(matrix, row-1, col);
        dfs(matrix, row+1, col);
        dfs(matrix, row, col-1);
        dfs(matrix, row, col+1);
    }

}