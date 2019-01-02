class Solution {
    
    List<String> results = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, new StringBuilder());
        return results;
    }
    
    private void helper(String s, int cur, StringBuilder sb) {
        if (cur == 4) { 
            if (s.length() == 0) results.add(sb.toString());
            return;
        }
        int upper = Math.min(s.length(), 3);
        for (int i = 1; i <= upper; i++) {
            if (i == 1 || s.charAt(0) != '0') {
                String next = s.substring(0, i);
                if (next.length() < 3 || Integer.parseInt(next) <= 255) {
                    StringBuilder tsb = new StringBuilder(sb);
                    tsb.append(next);
                    if (cur != 3) tsb.append('.');
                    helper(s.substring(i), cur+1, tsb);
                }
            }
        }
    }
}