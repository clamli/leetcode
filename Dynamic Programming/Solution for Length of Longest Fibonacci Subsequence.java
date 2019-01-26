class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length, res = 2;
        Set<Integer> set = new HashSet<>();
        for (int num : A) set.add(num);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n - 1; j++) {
                int a = A[i], b = A[j], l = 2;
                while (set.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                res = Math.max(res, l);
            }
        }
        return res == 2 ? 0 : res;
    }
}