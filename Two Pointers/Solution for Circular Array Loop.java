class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int fast = next(i, nums), slow = i;
            while ((nums[i]*nums[fast] > 0 && nums[i]*nums[next(fast, nums)] > 0) && nums[i]*nums[slow] > 0) {
                if (fast == slow) {
                    if (next(fast, nums) != fast) return true;
                    break;
                }
                fast = next(next(fast, nums), nums);
                slow = next(slow, nums);
            } 
            int start = i, val = nums[i];
            while (nums[start]*val > 0) {
                nums[start] = 0;
                start = next(start, nums);
            }
        }
        return false;
    }
    
    private int next(int curidx, int[] nums) {
        curidx += nums[curidx];
        if (curidx < 0) curidx += nums.length;
        return curidx % nums.length;
    }
}