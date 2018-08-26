class Solution {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        int[] resArr;
        if (num1.length() <= num2.length()) resArr = multiple(num2, num1);
        else resArr = multiple(num1, num2);
        StringBuilder sb = new StringBuilder();
        if (resArr[0] != 0) sb.append(resArr[0]);
        for (int i = 1; i < resArr.length; i++) sb.append(resArr[i]);
        return sb.toString();
    }
    
    private int[] multiple(String num1, String num2) {
        int idx = 0, multi1[] = new int[num1.length()], multi2[] = new int[num2.length()];
        for (char ch : num1.toCharArray()) multi1[idx++] = ch - 48;
        idx = 0;
        for (char ch : num2.toCharArray()) multi2[idx++] = ch - 48;
        int pos = 0, sum[] = new int[num1.length()+num2.length()];
        for (int i = multi2.length-1; i >= 0; i--) {
            int res[] = new int[multi1.length+1], carry = 0;
            idx = multi1.length;
            for (int j = multi1.length-1; j >= 0; j--) {
                int tmp = multi2[i]*multi1[j] + carry;
                res[idx--] = tmp%10;
                carry = tmp/10;
            }
            if (carry != 0) res[0] = carry;
            add(sum, res, pos++);
        }
        return sum;
    }
    
    private void add(int[] sum, int[] res, int pos) {
        int carry = 0;
        for (int i = sum.length-1-pos, j = res.length-1; j >= 0; i--, j--) {
            int tmp = sum[i] + res[j] + carry;
            sum[i] = tmp%10;
            carry = tmp/10;
        }
        if (carry != 0) sum[0] = carry;
    }
}