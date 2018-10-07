public class Solution {
    public String reverseWords(String s) {
        String[] res = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = res.length-1; i >= 1; i--) {
            sb.append(res[i]);
            sb.append(' ');
        }
        sb.append(res[0]);
        return sb.toString();
    }
}