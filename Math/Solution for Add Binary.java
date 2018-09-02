class Solution {
    public String addBinary(String a, String b) {
        int upper = Math.max(a.length(), b.length()), carry = 0;
        int[] res = new int[upper+1];
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--, j--) {
            int numa = 0, numb = 0;
            if (i >= 0) numa = a.charAt(i)-'0';
            if (j >= 0) numb = b.charAt(j)-'0';
            int tmp = numa + numb + carry;
            res[upper--] = tmp%2;
            carry = tmp/2;
        }
        if (carry != 0) res[0] = carry;
        StringBuilder sb = new StringBuilder();
        if (res[0] != 0) sb.append(res[0]);
        for (int i = 1; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}