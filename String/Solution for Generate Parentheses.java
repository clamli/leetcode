class Solution {

    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(n-1, n, res, new StringBuilder(""), '(');
        return res;
    }
    private void helper(int l, int r, List<String> res, StringBuilder ans, char ch) {
        
        if (l < 0 || r < 0 || l > r) return;
        else {
            if (ch == '(') {
                ans.append('(');
            } else {
                ans.append(')');
                if (l == 0 && r == 0) {
                    res.add(ans.toString());
                }
            }
        }
        
        helper(l-1, r, res, ans, '(');
        helper(l, r-1, res, ans, ')');
        
        ans.deleteCharAt(ans.length()-1);
    }
}