class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1<<n];
        
        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            int mask = 1 << i;
            dp[i][mask] = 0;
            Q.offer(new int[]{i, mask});
        }
        
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int next : graph[cur[0]]) {
                int nextMask = cur[1] | (1<<next);
                if (dp[next][nextMask] > dp[cur[0]][cur[1]] + 1) {
                    dp[next][nextMask] = dp[cur[0]][cur[1]] + 1;
                    Q.offer(new int[]{next, nextMask});
                }
            }
        }
        
        int min = Integer.MAX_VALUE, idx = dp[0].length - 1;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i][idx]);
        }
        return min;
    }
}