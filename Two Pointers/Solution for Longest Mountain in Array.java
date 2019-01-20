class Solution {
    public int longestMountain(int[] A) {
        int up = 0, down = 0, max = 0;
        for (int i = 1; i < A.length; i++) {
            if ((A[i] > A[i-1] && down > 0) || (A[i] == A[i-1])) {
                up = 0;
                down = 0;
            }
            if (A[i] > A[i-1]) up++;
            if (A[i] < A[i-1]) down++;
            if (up > 0 && down > 0) max = Math.max(max, up + down + 1);
        }
        return max;
    }
}