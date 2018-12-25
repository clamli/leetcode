class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        int pos = 0;
        for (char ch : order.toCharArray()) {
            dict[ch-'a'] = pos++;
        }
        for (int i = 0; i < words.length-1; i++) {
            int len = Math.min(words[i].length(), words[i+1].length());
            int t = 0;
            for (; t < len; t++) {
                if (dict[words[i].charAt(t)-'a'] > dict[words[i+1].charAt(t)-'a']) return false;
                else if (dict[words[i].charAt(t)-'a'] < dict[words[i+1].charAt(t)-'a']) break;
            }
            if (t == len && words[i].length() > words[i+1].length()) return false;
        }
        return true;
    }
}