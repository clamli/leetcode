class Solution {
    // method 1: backtrack
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, new ArrayList<>(), result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append('.');
        List<List<String>> answer = new ArrayList<>();
        for (List<Integer> solution : result) {
            List<String> tran2Str = new ArrayList<>();
            for (int col : solution) {
                sb.setCharAt(col, 'Q');
                tran2Str.add(sb.toString());
                sb.setCharAt(col, '.');
            }
            answer.add(tran2Str);
        }
        return answer;
    }
    
    private void backtrack(int n, List<Integer> solution, List<List<Integer>> res) {
        if (solution.size() == n) {
            res.add(new ArrayList<>(solution));
            return;
        }
        int row = solution.size();
        for (int col = 0; col < n; col++) {
            boolean flag = true;
            for (int prow = 0; prow < solution.size(); prow++) {
                int pcol = solution.get(prow);
                if (pcol == col) {
                    flag = false;
                    break;
                } else {
                    double k = 1.0*(prow- row)/(pcol - col);
                    if (k == 1 || k == -1) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                solution.add(col);
                backtrack(n, solution, res);
                solution.remove(solution.size()-1);
            }
        }
        return;
    }
}