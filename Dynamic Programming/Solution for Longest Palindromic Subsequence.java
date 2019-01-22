class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), len = 1, dp[][] = new int[n][n];
        char[] chArr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (chArr[i] != chArr[j]) {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
            }
        }
        return dp[0][n-1];
    }
}