class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int max = 0;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] == 0) {
                    max = Math.max(max, dfs(matrix, res, n, m, i, j, Integer.MIN_VALUE));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int[][] res, int n, int m, int row, int col, int pre) {
        if (row < 0 || col < 0 || row >= n || col >= m) return 0;
        if (pre != Integer.MIN_VALUE && pre >= matrix[row][col]) return 0;
        if (res[row][col] != 0) return res[row][col];
        int num1 = dfs(matrix, res, n, m, row+1, col, matrix[row][col]);
        int num2 = dfs(matrix, res, n, m, row-1, col, matrix[row][col]);
        int num3 = dfs(matrix, res, n, m, row, col+1, matrix[row][col]);
        int num4 = dfs(matrix, res, n, m, row, col-1, matrix[row][col]);
        res[row][col] = Math.max(Math.max(num1, num2), Math.max(num3, num4)) + 1;
        return res[row][col];
    }
}