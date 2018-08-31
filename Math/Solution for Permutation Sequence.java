class Solution {
    // method 1: backtrack
//     public String getPermutation(int n, int k) {
//         List<String> res = new ArrayList<String>();
//         Set<Integer> used = new HashSet<>();
//         backtrack(n, k, new StringBuilder(""), used, 0, res);
//         return res.get(0);
//     }
    
//     private int backtrack(int n, int k, StringBuilder tmp, Set<Integer> used, int accum, List<String> res) {
//         if (tmp.length() == n) {
//             accum++;
//             if (accum == k) {
//                 res.add(tmp.toString());
//             }
//             return accum;
//         }
//         for (int i = 1; i <= n; i++) {
//             if (!used.contains(i)) {
//                 tmp.append(i);
//                 used.add(i);
//                 accum = backtrack(n, k, tmp, used, accum, res);
//                 if (accum >= k) return accum;
//                 used.remove(i);
//                 tmp.deleteCharAt(tmp.length()-1);                    
//             }
//         }
//         return accum;
//     }
    
    //  method 2
    public String getPermutation(int n, int k) {
        int factor = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factor *= i;
        }
        StringBuilder sb = new StringBuilder("");
        helper(k-1, list, factor/n, sb);
        return sb.toString();
    }
    
    private void helper(int k, List<Integer> list, int factor, StringBuilder sb) {
        if (list.size() == 1) {
            sb.append(list.get(0));
            return;
        }
        int idx = k / factor;
        k = k % factor;
        sb.append(list.get(idx));
        list.remove(idx);
        helper(k, list, factor/list.size(), sb);
    }
}