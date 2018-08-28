class Solution {
    // method 1
    // public boolean isMatch(String s, String p) {
    //     if (p.length() == 0) 
    //         return s.length() == 0;
    //     else if (s.length() == 0) 
    //         return p.length() == 0 || (p.charAt(0) == '*' && isMatch(s, p.substring(1)));
    //     else if (p.charAt(0) != '*') 
    //         return (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
    //     else /* p.charAt(0) == '*' */ {
    //         int start = 0;
    //         do {
    //             if (isMatch(s.substring(start++), p.substring(1)))
    //                 return true;
    //         } while (start <= s.length());
    //     }
    //     return false;
    // }
    
    // method 2
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*') dp[0][i] = true;
            else break;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
}