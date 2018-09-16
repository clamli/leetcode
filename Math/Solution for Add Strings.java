class Solution {
    public String addStrings(String num1, String num2) {
        int maxlen = Math.max(num1.length(), num2.length());
        int res[] = new int[maxlen+1], carry = 0, idx1 = num1.length()-1, idx2 = num2.length()-1;
        for (int i = maxlen; i >= 1; i--) {
            int op1 = 0, op2 = 0;
            if (idx1 >= 0) {
                op1 = num1.charAt(idx1) - '0';
                idx1--;
            }
            if (idx2 >= 0) {
                op2 = num2.charAt(idx2) - '0';
                idx2--;
            }
            int sum = op1 + op2 + carry;
            carry = sum / 10;
            res[i] = sum % 10;
        }
        if (carry != 0) {
            res[0] = carry;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i);
        }
        String ret;
        if (sb.charAt(0) == '0') {
            if (sb.length() == 1) ret = "0";
            else ret = sb.substring(1, maxlen+1).toString();
        } else {
            ret = sb.toString();
        }
        return  ret;
    }
}