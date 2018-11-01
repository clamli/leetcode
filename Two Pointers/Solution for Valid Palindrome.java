class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lo = Character.toLowerCase(s.charAt(left)), hi = Character.toLowerCase(s.charAt(right));
            if (isValid(lo) && isValid(hi)) {
                if (lo != hi) return false;
                left++;
                right--;
            }
            else {
                if (!isValid(lo)) left++;
                if (!isValid(hi)) right--;
            }
        }
        return true;
    }
    
    private boolean isValid(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}