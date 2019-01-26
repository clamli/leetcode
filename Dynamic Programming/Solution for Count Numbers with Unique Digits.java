class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n > 10) return 0;
        int dp = 9, res = 10;
        for (int i = 2; i <= n; i++) {
            dp *= 11 - i;
            res += dp;
        }
        return res;
    }
}