class Solution {
    public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return sum - nums.length*min;
    }
}