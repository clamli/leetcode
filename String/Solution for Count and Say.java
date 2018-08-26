class Solution {
    public String countAndSay(int n) {
        String prev = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            char prevc = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == prevc) cnt++;
                else {
                    sb.append(cnt);
                    sb.append(prevc);
                    prevc = prev.charAt(j);
                    cnt = 1;
                }
            }
            sb.append(cnt);
            sb.append(prevc);
            prev = sb.toString();
        }
        return prev;
    }
}