class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, n, new ArrayList<>(), 0);
    }
    
    private int backtrack(int curRow, int n, List<Integer> usedCols, int cnt) {
        if (curRow == n) {
            return cnt + 1;
        }
        for (int curCol = 0; curCol < n; curCol++) {
            boolean flag = true;
            for (int row = 0; row < usedCols.size(); row++) {
                int col = usedCols.get(row);
                if (col == curCol) {
                    flag = false;
                    break;
                } else {
                    double k = 1.0*(row - curRow) / (col - curCol);
                    if (k == 1 || k == -1) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                usedCols.add(curCol);
                cnt = backtrack(curRow+1, n, usedCols, cnt);
                usedCols.remove(usedCols.size()-1);
            }
        }
        return cnt;
    }
}