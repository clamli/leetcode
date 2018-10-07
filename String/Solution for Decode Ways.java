class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()], num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i) - '0';
        }
        dp[0] = (s.charAt(0) == '0') ? 0:1;
        for (int i = 1; i < num.length; i++) {
            if (dp[i-1] == 0) break;
            if (num[i] != 0) dp[i] = dp[i-1];
            if (num[i-1] != 0) {
                int digit = num[i-1]*10 + num[i];
                if (digit <= 26 && digit > 0) {
                    if (i > 1) dp[i] += dp[i-2];
                    else dp[i] += 1;
                }
            }
        }
        return dp[num.length-1];
    }
}