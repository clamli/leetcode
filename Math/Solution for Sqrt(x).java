class Solution {
    // method 1: naive approach
    // public int mySqrt(int x) {
    //     int res = 0;
    //     for (int i = 0; i <= x; i++) {
    //         int num = i*i;
    //         if (num > x) {
    //             res = i-1;
    //             break;
    //         } else if (num == x) {
    //             res = i;
    //             break;
    //         }
    //     }
    //     return res;
    // }
    
    // method 2: binary search 垃圾binary search，写的啥玩意??!!
    // public int mySqrt(int x) {
    //     long lo = 0, hi = x;
    //     while (lo < hi) {
    //         long mid = (lo + hi + 1) / 2;
    //         long prod = mid*mid;
    //         if (prod > x) {
    //             hi = mid-1;
    //         } else if (prod < x) {
    //             lo += 1;
    //         } else {
    //             return (int)mid;
    //         }
    //     }
    //     return (int)lo;
    // }
    
    // method 3: awesome binary search
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int lo = 0, hi = x, res = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2, div = x/mid;
            if (div < mid) {
                hi = mid-1;
            } else {
                res = mid;
                lo = mid+1;
            }
        }
        return res;
    }
}