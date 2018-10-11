class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount];
        return backtrack(coins, amount, cache);
    }
    
    private int backtrack(int[] coins, int rem, int[] cache) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (cache[rem-1] != 0) return cache[rem-1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int tmp = backtrack(coins, rem-coins[i], cache);
            if (tmp != -1) min = Math.min(min, tmp+1);
        }
        cache[rem-1] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[rem-1];
    }
}