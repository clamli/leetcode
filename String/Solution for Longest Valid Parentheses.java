class Solution {
    // method 1: stack
    // public int longestValidParentheses(String s) {
    //     int maxlen = 0;
    //     Stack<Integer> S = new Stack<Integer>();
    //     S.push(-1);
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == '(') {
    //             S.push(i);
    //         } else {
    //             S.pop();
    //             if (S.isEmpty()) {
    //                 S.push(i);
    //             } else {
    //                 maxlen = Math.max(maxlen, i-S.peek());
    //             }
    //         }
    //     }
    //     return maxlen;
    // }
    
    // method 2: without extra space
    // public int longestValidParentheses(String s) {
    //     int left = 0, right = 0, maxlen = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == '(') left++;
    //         else right++;
    //         if (left == right) maxlen = Math.max(maxlen, left*2);
    //         else if (right > left) {
    //             left = 0;
    //             right = 0;
    //         }
    //     }
    //     left = 0;
    //     right = 0;
    //     for (int i = s.length()-1; i >= 0; i--) {
    //         if (s.charAt(i) == '(') left++;
    //         else right++;
    //         if (left == right) maxlen = Math.max(maxlen, left*2);
    //         else if (right < left) {
    //             left = 0;
    //             right = 0;
    //         }
    //     }
    //     return maxlen;
    // }
    
    // method 3: dp
    public int longestValidParentheses(String s) {
        int dp[] = new int[s.length()], maxlen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i < 2 ? 0 : dp[i-2]) + 2;                
                } else if (i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + ((i - dp[i-1] - 2) < 0 ? 0 : dp[i-dp[i-1]-2]) + 2;
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }
}