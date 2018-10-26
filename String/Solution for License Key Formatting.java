class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int cnt = 0, start = 0;
        StringBuilder sb = new StringBuilder();
        while (start < S.length() && S.charAt(start) == '-') {
            start++;
        }
        for (int i = S.length()-1; i >= start; i--) {
            char ch = S.charAt(i);
            if (ch == '-') continue;
            cnt++;
            if (Character.isLetter(ch)) ch = Character.toUpperCase(ch);
            sb.append(ch);
            if (i != start && cnt == K) {
                cnt = 0;
                sb.append('-');
            }
        }
        return sb.reverse().toString();
    }
}