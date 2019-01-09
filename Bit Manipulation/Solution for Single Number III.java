class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int index = findOne(xor);
        int[] res = new int[2];
        for (int num : nums) {
            if (indexOne(num, index)) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
    
    private int findOne(int num) {
        int index = 0;
        while ((num&1) == 0) {
            num >>= 1;
            index++;
        }
        return index;
    }
    
    private boolean indexOne(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}