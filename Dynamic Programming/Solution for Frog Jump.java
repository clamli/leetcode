class Solution {
    // public boolean canCross(int[] stones) {
    //     int n = stones.length;
    //     boolean dp[] = new boolean[n];
    //     dp[0] = true;
    //     dp[1] = stones[1] == 1;
    //     Set<Integer>[] K = new HashSet[n];
    //     for (int i = 0; i < n; i++) {
    //         K[i] = new HashSet<>();
    //     }
    //     K[1].add(1);
    //     for (int i = 2; i < n; i++) {
    //         for (int j = 1; j < i; j++) {
    //             if (!dp[j]) continue;
    //             int curStep = stones[i] - stones[j];
    //             boolean flag;
    //             for (int preStep : K[j]) {
    //                 flag = Math.abs(curStep - preStep) <= 1;
    //                 if (flag) {
    //                     K[i].add(curStep);
    //                     dp[i] = true;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return dp[n-1];
    // }
    
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length - 1; i++) map.put(stones[i], new HashSet<>());
        map.get(0).add(1);
        int dest = stones[stones.length-1];
        for (int i = 0; i < stones.length - 1; i++) {
            for (int step : map.get(stones[i])) {
                int next = stones[i] + step;
                if (next == dest) return true;
                if (map.containsKey(next)) {
                    Set<Integer> nextStep = map.get(next);
                    if (step - 1 > 0) nextStep.add(step-1);
                    nextStep.add(step);
                    nextStep.add(step+1);
                }
            }
        }
        return false;
    }
}