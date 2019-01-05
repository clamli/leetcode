class Solution {
    public int singleNumber(int[] nums) {
        // a b    c : a b
        // 0 0    0 : 0 0
        // 0 1    0 : 0 1
        // 1 0    0 : 1 0
        // 0 0    1 : 0 1
        // 0 1    1 : 1 0
        // 1 0    1 : 0 0
        // a = a&(~b)&(~c) | (~a)&b&c
        // b = (~a)&b&(~c) | (~a)&(~b)&c
        int a = 0, b = 0;
        for (int c : nums) {
            int ta = a&(~b)&(~c) | (~a)&b&c;
            b = (~a)&b&(~c) | (~a)&(~b)&c;
            a = ta;
        }
        return b;
    }
}