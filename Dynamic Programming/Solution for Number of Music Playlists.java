class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        long fac[] = new long[N+1], mod = 1000000007;
        fac[1] = 1; 
        for (int i = 2; i <= N; i++) {
            fac[i] = (fac[i-1] * i) % mod;
        }
        long[][] dp = new long[N+1][L+1];
        for (int i = K + 1; i <= N; i++) {
            for (int j = i; j <= L; j++) {
                if (i == j || i == K+1) dp[i][j] = fac[i];
                else {
                    dp[i][j] = dp[i-1][j-1] * i + dp[i][j-1] * (i-K);
                }
                dp[i][j] %= mod;
            }
        }
        return (int) dp[N][L];
    }
}