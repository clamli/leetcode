class Solution {
    
    // naive method
//     public int lengthOfLIS(int[] nums) {
//         return lengthHelper(nums, Integer.MIN_VALUE, 0);
//     }
    
//     private int lengthHelper(int[] nums, int prev, int curidx) {
//         if (curidx == nums.length) return 0;
//         int take = -1;
//         if (prev < nums[curidx]) {
//             take = 1 + lengthHelper(nums, nums[curidx], curidx+1);
//         }
//         int nontake = lengthHelper(nums, prev, curidx+1);
//         return Math.max(take, nontake);
//     }
    
    
    // with cache
//     public int lengthOfLIS(int[] nums) {
//         return lengthHelper(nums, -1, 0, new HashMap<>());
//     }
    
//     private int lengthHelper(int[] nums, int previdx, int curidx, Map<Integer, Integer> cache) {
//         if (curidx == nums.length) return 0;
//         if (cache.containsKey(previdx)) return cache.get(previdx);
//         int take = -1;
//         if (previdx == -1 || nums[previdx] < nums[curidx]) {
//             take = 1 + lengthHelper(nums, curidx, curidx+1, cache);
//         }
//         int nontake = lengthHelper(nums, previdx, curidx+1, cache);
//         cache.put(previdx, Math.max(take, nontake));
//         return cache.get(previdx);
//     }
    
    
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxlen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxlen = Math.max(maxlen, dp[j]);
                }               
            }
            dp[i] = maxlen + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    
}