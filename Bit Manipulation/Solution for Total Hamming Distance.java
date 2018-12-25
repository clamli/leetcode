class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int t = 0; t < 32; t++) {
            int bitcount = 0;
            for (int i = 0; i < n; i++) {
                if (((nums[i] >> t)&1) == 1) bitcount++;
            }
            total += bitcount * (n - bitcount);
        }
        return total;
    }
}