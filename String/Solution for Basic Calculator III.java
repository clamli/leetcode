class Solution {
    public int calculate(String s) {
        if (s.length() == 0) return 0;
        Stack<Character> ops = new Stack<>();
        Stack<Integer> opr = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            else if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (++i < s.length() && Character.isDigit(s.charAt(i))) num = num * 10 + s.charAt(i) - '0';
                i--;
                opr.push(num);
            } else if (s.charAt(i) == '(') {
                ops.push('(');
            } else if (s.charAt(i) == ')') {
                while (ops.peek() != '(') opr.push(calculate(ops.pop(), opr.pop(), opr.pop()));
                ops.pop();
            } else {
                while (!ops.isEmpty() && judge(ops.peek(), s.charAt(i))) opr.push(calculate(ops.pop(), opr.pop(), opr.pop()));
                ops.push(s.charAt(i));
            }
        }
        while (!ops.isEmpty()) {
            opr.push(calculate(ops.pop(), opr.pop(), opr.pop()));
        }
        return opr.pop();
    }
    
    private boolean judge(char op1, char op2) {
        if (op1 == '(' || op1 == ')') return false;
        if ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) return false;
        return true;
    }
    
    private int calculate(char op, int num1, int num2) {
        int res = 0;
        if (op == '+') {
            res = num1 + num2;
        } else if (op == '-') {
            res = num2 - num1;
        } else if (op == '*') {
            res = num1 * num2;
        } else if (op == '/') {
            res = num2 / num1;
        }
        return res;
    }
}