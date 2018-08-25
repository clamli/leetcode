class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            int idx = 0;
            while (idx < needle.length() && i+idx < haystack.length() && haystack.charAt(i+idx) == needle.charAt(idx)) idx++;
            if (idx == needle.length()) return i;
        }
        return -1;
    }
}