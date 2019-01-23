class Solution {
    public boolean isSubsequence(String s, String t) {
        // int n = s.length(), m = t.length();
        // boolean[][] dp = new boolean[n+1][m+1];
        // for (int i = 0; i <= m; i++) dp[0][i] = true;
        // for (int j = 1; j <= m; j++) {
        //     for (int i = 1; i <= n; i++) {
        //         dp[i][j] = dp[i][j-1] || (dp[i-1][j-1] && (s.charAt(i-1) == t.charAt(j-1)));
        //         if (i == n && dp[i][j]) return true;
        //     }
        // }
        // return dp[n][m];
        
        // if (s.equals("")) return true;
        // Stack<Character> S = new Stack();
        // for (char ch : s.toCharArray()) S.push(ch);
        // int ptr = t.length() - 1;
        // while (!S.isEmpty() && ptr >= 0) {
        //     if (S.peek() == t.charAt(ptr)) S.pop();
        //     ptr--;
        // }
        // if (!S.isEmpty()) return false;
        // else return true;
        
        // List<Integer>[] A = new List[26];
        // for (int i = 0; i < t.length(); i++) {
        //     int idx = t.charAt(i) - 'a';
        //     if (A[idx] == null) A[idx] = new ArrayList<>();
        //     A[idx].add(i);
        // }
        // int prev = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     int idx = s.charAt(i) - 'a';
        //     if (A[idx] == null) return false;
        //     // int next = findNext(A[idx], prev);
        //     int next = Collections.binarySearch(A[idx], prev);
        //     if (next < 0) next = -next - 1;
        //     if (next == A[idx].size()) return false;
        //     prev = A[idx].get(next) + 1;
        // }
        // return true;
        
        if (s.length() > t.length()) return false;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int next = t.indexOf(s.charAt(i), prev);
            if (next == -1) return false;
            prev = next + 1;
        }
        return true;
        
        
        

    }
    
    // private int findNext(List<Integer> list, int target) {
    //     int lo = 0, hi = list.size() - 1, mid = 0;
    //     while (lo < hi) {
    //         mid = (lo + hi) / 2;
    //         if (list.get(mid) < target) lo++;
    //         else if (list.get(mid) > target) hi = mid;
    //         else return mid;
    //     }
    //     return (lo == hi && list.get(lo) >= target) ? list.get(lo) : -1;
    // }
}