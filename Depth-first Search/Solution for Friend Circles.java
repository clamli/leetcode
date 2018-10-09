class Solution {
    // dfs
//     private void dfs(int[][] M, int[] visit, int i) {
//         for (int j = 0; j < M[0].length; j++) {
//             if (M[i][j] != 0 && visit[j] == 0) {
//                 visit[j] = 1;
//                 dfs(M, visit, j);
//             }
//         }
//     }
    
//     public int findCircleNum(int[][] M) {
//         int[] visit = new int[M.length];
//         int count = 0;
//         for (int i = 0; i < M.length; i++) {
//             if (visit[i] != 1) {
//                 dfs(M, visit, i);
//                 count++;
//             }
//         }
//         return count;
//     }
    
    
    // bfs
    public int findCircleNum(int[][] M) {
        int[] visit = new int[M.length];
        int count = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visit[i] != 1) {
                Q.offer(i);
                while (!Q.isEmpty()) {
                    int j = Q.poll();
                    visit[j] = 1;
                    for (int t = 0; t < M.length; t++) {
                        if (M[j][t] == 1 && visit[t] != 1) {
                            Q.offer(t);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}