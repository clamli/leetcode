class Solution {
    
    public int consecutiveNumbersSum(int N) {
        int cnt = 0;
        for (int k = 0; k <= Math.sqrt(2*N); k++) {
            if ((2*N) % (k+1) == 0) {
                int x_2 = 2*N / (k+1) - k;
                if (x_2 != 0 && x_2 % 2 == 0) cnt++;
            }
        }
        return cnt;
    }
}