class Solution {
    
    int[] union = new int[26];
    
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) union[i] = i;
        for (String equation : equations) {
            if (equation.charAt(1) == '=') union[find(equation.charAt(0) - 'a')] = find(equation.charAt(3) - 'a');
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a')) return false;
        }
        return true;
    }
    
    private int find(int index) {
        while (index != union[index]) {
            union[index] = union[union[index]];
            index = union[index];
        }
        return index;
    }
}