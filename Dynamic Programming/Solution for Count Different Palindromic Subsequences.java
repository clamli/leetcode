class Solution {
    public int countPalindromicSubsequences(String S) {
        int n = S.length(), mod = 1000000007;
        int[][] dp = new int[n][n];
        char[] chArr = S.toCharArray();
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int dist = 1; dist < n; dist++) {
            for (int i = 0; i < n - dist; i++) {
                int j = i + dist;
                if (chArr[i] != chArr[j]) {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                } else {
                    int low = i + 1;
                    int high = j - 1;
                    while (low <= high && chArr[low] != chArr[i]) low++;
                    while (low <= high && chArr[high] != chArr[j]) high--;
                    if (low > high) {
                        dp[i][j] = 2 * dp[i+1][j-1] + 2;
                    } else if (low == high) {
                        dp[i][j] = 2 * dp[i+1][j-1] + 1;
                    } else {
                        dp[i][j] = 2 * dp[i+1][j-1] - dp[low+1][high-1];   
                    }
                }
                if (dp[i][j] < 0) dp[i][j] += mod;     // 
                else dp[i][j] %= mod;
            }
        }
        
        return dp[0][n-1];
    }
}