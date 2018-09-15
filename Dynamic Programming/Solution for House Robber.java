class Solution {
    public int rob(int[] nums) {
        int n = nums.length, preMax = 0, curMax = 0;        
        for (int i = 0; i < n; i++) {
            int tmp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = tmp;
        }
        return curMax;
    }
}