class Solution {
    // O(N)
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums.length == 0) return new int[0];
    //     int[] result = new int[nums.length-k+1];
    //     for (int i = 0; i <= nums.length-k; i++) {
    //         int max = Integer.MIN_VALUE;
    //         for (int j = i; j < i + k; j++) {
    //             max = Math.max(max, nums[j]);
    //         }
    //         result[i] = max;
    //     }
    //     return result;
    // }

    // O(nlogn)
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if (nums.length == 0) return new int[0];
    //     int[] result = new int[nums.length-k+1];
    //     Queue<Integer> Q = new PriorityQueue<>(k, new Comparator<Integer>() {
    //         @Override
    //         public int compare(Integer o1, Integer o2) {
    //             return o2 - o1;
    //         }
    //     });
    //     for (int i = 0; i < k; i++) {
    //         Q.offer(nums[i]);
    //     }
    //     result[0] = Q.peek();
    //     for (int i = 1; i <= nums.length-k; i++) {
    //         Q.remove(nums[i-1]);
    //         Q.offer(nums[i+k-1]);
    //         result[i] = Q.peek();
    //     }
    //     return result;
    // }
    
    // O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int idx = 0, result[] = new int[nums.length-k+1];
        Deque<Integer> DQ = new ArrayDeque();       // save index
        for (int i = 0; i < nums.length; i++) {
            while (!DQ.isEmpty() && DQ.peek() < i - k + 1) DQ.poll();
            while (!DQ.isEmpty() && nums[DQ.peekLast()] < nums[i]) DQ.pollLast();
            DQ.offer(i);
            if (i >= k-1) {
                result[idx++] = nums[DQ.peek()];
            }
        }
        return result;
    }
}