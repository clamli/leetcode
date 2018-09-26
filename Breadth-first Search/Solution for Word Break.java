class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int start, int n, int k, List<Integer> tmp, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n-k+1; i++) {
            tmp.add(i);
            backtrack(i+1, n, k-1, tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }
}
