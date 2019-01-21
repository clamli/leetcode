class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / k;
        return dfs(nums, 0, target, k, new boolean[nums.length], 0);
    }
    private boolean dfs(int[] nums, int start, int target, int k, boolean[] isVisited, int curSum) {
        if (curSum == target) {
            k--;
            if (k == 0) return true;
            curSum = 0;
            start = 0;
        } 
        if (curSum < target) {
            for (int i = start; i < nums.length; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    if (dfs(nums, i+1, target, k, isVisited, curSum + nums[i])) return true;
                    isVisited[i] = false;
                }
            }
        }
        return false;
    }
}