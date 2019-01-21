class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0, rem = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (map.containsKey(sum) && i - map.get(sum) > 1) return true; 
            }
            return false;
        } else {
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                rem = sum % k;
                if (!map.containsKey(rem)) map.put(rem, i);
                else if (i - map.get(rem) > 1) return true;
            }
            return false;
        }
    }
}