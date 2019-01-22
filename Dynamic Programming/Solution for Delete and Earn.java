class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] bucket = new int[n];
        for (int num : nums) {
            bucket[num] += num;
        }
        int[] dp = new int[n];
        dp[1] = bucket[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + bucket[i], dp[i-1]);
        }
        return dp[n-1];
    }
}