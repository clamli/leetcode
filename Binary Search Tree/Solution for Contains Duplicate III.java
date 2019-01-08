class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long bucket = ((long) nums[i] - Integer.MIN_VALUE) / ((long) t+1);
            if (map.containsKey(bucket) || 
                (map.containsKey(bucket+1) && Math.abs(map.get(bucket+1) - nums[i]) <= t) ||
                (map.containsKey(bucket-1) && Math.abs(map.get(bucket-1) - nums[i]) <= t)) return true;
            if (map.size() >= k) {
                long removed = ((long) nums[i-k] - Integer.MIN_VALUE) / ((long) t+1);
                map.remove(removed);
            }
            map.put(bucket, (long) nums[i]);
        }
        return false;
    }
    
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     if (k <= 0 || t < 0) return false;
    //     TreeSet<Long> treeSet = new TreeSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         Long floor = treeSet.floor((long)nums[i] + t);
    //         Long ceiling = treeSet.ceiling((long)nums[i] - t);
    //         if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) return true;
    //         if (treeSet.size() >= k) treeSet.remove((long)nums[i-k]);
    //         treeSet.add((long)nums[i]);
    //     }
    //     return false;
    // }
    
    
    

    
    
    
}