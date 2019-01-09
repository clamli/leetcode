class Solution {

    
    private char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public int strobogrammaticInRange(String low, String high) {
        int[] count = new int[1];
        for (int i = low.length(); i <= high.length(); i++) {
            dfs(low, high, new char[i], 0, i-1, count);
        }
        return count[0];
    }
    
    private void dfs(String low, String high, char[] ch, int left, int right, int[] count) {
        if (left > right) {
            String str = new String(ch);
            if ((str.length() == low.length() && str.compareTo(low) < 0) || (str.length() == high.length() && str.compareTo(high) > 0)) {
                return;
            }
            count[0]++;
            return;
        }
        for (char[] pair : pairs) {
            ch[left] = pair[0];
            ch[right] = pair[1];
            if (ch.length != 1 && ch[0] == '0') continue;
            if (left == right && pair[0] != pair[1]) continue;
            dfs(low, high, ch, left+1, right-1, count);
        }
    }
}