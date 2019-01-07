class Solution {
    // DFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !isValid(graph, colors, i, 1)) return false;
        }
        return true;
    }
    
    private boolean isValid(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] != 0) return colors[i] == color;
        colors[i] = color;
        for (int next : graph[i]) {
            if (!isValid(graph, colors, next, -color)) return false;
        }
        return true;
    }
    
    
    // BFS
    // public boolean isBipartite(int[][] graph) {
    //     int n = graph.length;
    //     int[] colors = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         if (colors[i] == 0) {
    //             colors[i] = 1;
    //             Queue<Integer> Q = new LinkedList<>();
    //             Q.offer(i);
    //             while (!Q.isEmpty()) {
    //                 int cur = Q.poll();
    //                 for (int next : graph[cur]) {
    //                     if (colors[next] == 0) {
    //                         colors[next] = -colors[cur];
    //                         Q.offer(next);
    //                     } else if (colors[next] != -colors[cur]) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
    
}