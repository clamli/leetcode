class Solution {
    public int minDeletionSize(String[] A) {
        if (A.length == 0) return 0;
        int res = 0, len = A[0].length();
        boolean[] sorted = new boolean[A.length];
        for (int i = 0; i < len; i++) {
            int j;
            for (j = 0; j < A.length-1; j++) {
                if (!sorted[j] && A[j].charAt(i) > A[j+1].charAt(i)) {
                    res++;
                    break;
                }
            }
            if (j < A.length - 1) continue;
            for (j = 0; j < A.length-1; j++) {
                if (A[j].charAt(i) < A[j+1].charAt(i)) sorted[j] = true;
            }
        }
        return res;
    }
}