class Solution {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> S = new Stack();
        for (int i = 0; i < A.length; i++) {
            if (S.isEmpty() || A[S.peek()] > A[i]) S.add(i); 
        }
        int res = 0;
        for (int i = A.length-1; i >= res; i--) {
            while (!S.isEmpty() && A[S.peek()] <= A[i]) res = Math.max(res, i-S.pop());
        }
        return res;
    }
}