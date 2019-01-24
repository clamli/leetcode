class Solution {
    
    // recursive
    // public int combinationSum4(int[] nums, int target) {
    //     if (target == 0) return 1;
    //     if (target < 0) return 0;
    //     int res = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         res += combinationSum4(nums, target - nums[i]);
    //     }
    //     return res;
    // }
    
    // dp
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}