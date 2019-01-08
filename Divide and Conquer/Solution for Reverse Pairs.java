class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        int ptr1 = start, ptr2 = mid+1;
        while (ptr1 <= mid) {
            while (ptr2 <= end && nums[ptr2] < nums[ptr1]/2.0) ptr2++;
            count += ptr2 - mid - 1;
            ptr1++;
        }
        // Arrays.sort(nums, start, end+1);
        merge(nums, start, mid, end);
        return count;
    }
    private void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end-start+1];
        int ptr1 = start, ptr2 = mid+1, idx = 0;
        while (ptr1 <= mid && ptr2 <= end) {
            if (nums[ptr1] < nums[ptr2]) {
                tmp[idx++] = nums[ptr1++];
            } else {
                tmp[idx++] = nums[ptr2++];
            }
        }
        while (ptr1 <= mid) tmp[idx++] = nums[ptr1++];
        while (ptr2 <= end) tmp[idx++] = nums[ptr2++];
        idx = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = tmp[idx++];
        }
    }
}