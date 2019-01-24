class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        int base = 1, next = 2;
        for (int i = 1; i <= num; i++) {
            if (i == next) {
                dp[i] = 1;
                base = next;
                next *= 2;
            } else {
                dp[i] = 1 + dp[i-base];
            }
        }
        return dp;
    }  
}