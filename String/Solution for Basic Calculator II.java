class Solution {
    public int calculate(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
        Stack<Character> sOp = new Stack();
        Stack<Integer> sNum = new Stack();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                num = num*10 + ch-'0';
                if (i == s.length()-1 || !Character.isDigit(s.charAt(i+1))) {
                    sNum.push(num);
                    num = 0;
                }
            } else {
                int prio = map.get(ch);
                while (!sOp.isEmpty() && map.get(sOp.peek()) >= prio) {
                    int num2 = sNum.pop(), num1 = sNum.pop();
                    char op = sOp.pop();
                    sNum.push(calculate(num1, num2, op));
                }
                sOp.push(ch);
            }
        }
        while (!sOp.isEmpty()) {
            int num2 = sNum.pop(), num1 = sNum.pop();
            char op = sOp.pop();
            sNum.push(calculate(num1, num2, op));
        }
        return sNum.pop();
    }
    
    private int calculate(int num1, int num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }
}