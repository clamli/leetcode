class Solution {
    // method 1: O(N)
    // public double myPow(double x, int n) {
    //     double res = 1;
    //     int upper = Math.abs(n);
    //     for (int i = 0; i < upper; i++) {
    //         res *= x;
    //     }
    //     if (n < 0) res = 1/res;
    //     return res;
    // }
    
    // method 2: O(logN)
    // public double myPow(double x, int n) {
    //     double res = 1;
    //     int pn = Math.abs(n);
    //     while (pn != 0) {
    //         int t = 1;
    //         double tmp = 1;
    //         while (t <= pn) {
    //             if (t == 1) tmp = x;
    //             else tmp *= tmp;
    //             t *= 2;
    //         }
    //         res *= tmp;
    //         pn -= t/2;
    //     }
    //     if (n < 0) res = 1/res;
    //     return res;
    // }
    
//     private double fastPow(double x, long n) {
//         if (n == 0) {
//             return 1.0;
//         }
//         double half = fastPow(x, n / 2);
//         if (n % 2 == 0) {
//             return half * half;
//         } else {
//             return half * half * x;
//         }
//     }
//     public double myPow(double x, int n) {
//         long N = n;
//         if (N < 0) {
//             x = 1 / x;
//             N = -N;
//         }

//         return fastPow(x, N);
//     }
    
    // method 3: half * half recursive
//     public double myPow(double x, int n) {
//         long pn = n;
//         return pn < 0 ? 1/pow(x, -pn) : pow(x, pn);
//     }
    
//     private double pow(double x, long n) {
//         if (n == 0) return 1;
//         double half = pow(x, n/2);
//         return n%2 == 0 ? half*half : x*half*half;
//     }
    
    // method 4: half * half iterative
    public double myPow(double x, int n) {
        long pn = n;
        if (pn < 0) {
            pn = -pn;
            x = 1/x;
        }
        double cur = x, res = 1;
        for (long i = pn; i > 0; i /= 2) {
            if (i % 2 == 1) res *= cur;
            cur *= cur;
        }
        return res;
    }
}