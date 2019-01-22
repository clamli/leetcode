class Solution {
    
    int[][] choices = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    double[][][] dp;
    
    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[N][N][K+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
                dp[i][j][0] = 1;
            }
        }
        return dfs(N, K, r, c);
    }
    private double dfs(int N, int K, int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) return 0;
        if (dp[row][col][K] != -1) {
            return dp[row][col][K];
        }
        if (K == 0) return 1;
        double res = 0;
        for (int i = 0; i < choices.length; i++) {
            res += 0.125 * dfs(N, K-1, row + choices[i][0], col + choices[i][1]);
        }
        dp[row][col][K] = res;
        return res;
    }
}