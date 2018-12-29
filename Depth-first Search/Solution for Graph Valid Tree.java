class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] =  new HashSet<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        boolean[] isVisited = new boolean[n];
        
        if (!dfs(graph, isVisited, 0, -1)) return false;
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) return false;
        }
        return true;
    }
    
    private boolean dfs(Set<Integer>[] graph, boolean[] isVisited, int curNode, int preNode) {
        if (isVisited[curNode]) return false;
        isVisited[curNode] = true;
        for (int nextNode : graph[curNode]) {
            if (nextNode != preNode) {
                if (!dfs(graph, isVisited, nextNode, curNode)) return false;
            }
        }
        // isVisited[curNode] = false;
        return true;
    }
    
    private void count(Set<Integer>[] graph, boolean[] isVisited, int curNode) {
        if (isVisited[curNode]) return;
        isVisited[curNode] = true;
        for (int nextNode : graph[curNode]) {
            count(graph, isVisited, nextNode);
        }
    }
}