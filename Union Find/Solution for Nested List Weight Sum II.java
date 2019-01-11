class Solution {
    
    int[][] choices = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (m == 0 || n == 0) return new ArrayList<>();
        int[] union = new int[m*n];
        int count = 0;
        Arrays.fill(union, -1);
        List<Integer> result = new ArrayList<>();
        for (int[] pos : positions) {
            int root = pos[0]*n + pos[1];
            union[root] = root;
            count++;
            for (int[] choi : choices) {
                int row = pos[0] + choi[0], col = pos[1] + choi[1];
                int neig = row*n + col;
                if (row < 0 || col < 0 || row >= m || col >= n || union[neig] == -1) continue;
                int neigroot = findRoot(union, neig);
                if (root != neigroot) {
                    union[root] = neigroot;
                    root = neigroot;
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }
    
    private int findRoot(int[] union, int neig) {
        while (neig != union[neig]) {
            union[neig] = union[union[neig]];
            neig = union[neig];
        }
        return neig;
    }
}