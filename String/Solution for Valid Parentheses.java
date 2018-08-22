class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack S = new Stack<Integer>();
        Map map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) S.push(ch);
            else {
                if (S.isEmpty() || map.get(S.pop()) != ch) return false;
            }
        }
        return S.isEmpty();
    }
}