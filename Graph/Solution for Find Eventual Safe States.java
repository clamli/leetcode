class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] colors = new int[N]; // 0: not visited, 1: visited/false, 2: visited/true
        // boolean[] isVisited = new boolean[N];
        // boolean[] status = new boolean[N];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (dfs(graph, colors, i)) res.add(i);
        }
        return res;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int start) {
        if (colors[start] != 0) return colors[start] == 2;
        colors[start] = 1;
        for (int next : graph[start]) {
            if (!dfs(graph, colors, next)) return false;
        }
        colors[start] = 2;
        return true;
    }
}