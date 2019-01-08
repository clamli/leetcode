class Solution {
    
//     public List<String> findStrobogrammatic(int n) {
//         int mid = n / 2;
//         List<String> res = new ArrayList<>();
//         dfs(1, mid, n, new StringBuilder(), res);
//         return res;
//     }
    
//     private void dfs(int cur, int bound, int n, StringBuilder curStr, List<String> res) {
//         if (cur > bound) {
//             res.addAll(complete(curStr, n));
//             return;
//         }
//         if (cur != 1) {
//             StringBuilder sb1 = new StringBuilder(curStr);
//             sb1.append('0');
//             dfs(cur+1, bound, n, sb1, res);
//         }
//         StringBuilder sb2 = new StringBuilder(curStr);
//         sb2.append('1');
//         dfs(cur+1, bound, n, sb2, res);
//         StringBuilder sb3 = new StringBuilder(curStr);
//         sb3.append('8');
//         dfs(cur+1, bound, n, sb3, res);
//         StringBuilder sb4 = new StringBuilder(curStr);
//         sb4.append('6');
//         dfs(cur+1, bound, n, sb4, res);
//         StringBuilder sb5 = new StringBuilder(curStr);
//         sb5.append('9');
//         dfs(cur+1, bound, n, sb5, res);
//     }
    
//     private List<String> complete(StringBuilder first, int n) {
//         StringBuilder second = new StringBuilder();
//         for (int i = first.length()-1; i >= 0; i--) {
//             if (first.charAt(i) == '0' || first.charAt(i) == '1' || first.charAt(i) == '8') {
//                 second.append(first.charAt(i));
//             } else if (first.charAt(i) == '6') {
//                 second.append('9');
//             } else {
//                 second.append('6');
//             }
//         }
//         List<String> res = new ArrayList<>();
//         if (n % 2 != 0) {
//             res.add(first.toString() + '0' + second.toString());
//             res.add(first.toString() + '1' + second.toString());
//             res.add(first.toString() + '8' + second.toString());
//         } else {
//             res.add(first.toString() + second.toString());
//         }
//         return res;
//     }
    
    
    
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        
        List<String> list = helper(n-2, m);
        
        List<String> res = new ArrayList<>();
        for (String str : list) {
            if (n != m) {
                res.add("0" + str + "0");
            }
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        return res;
    }
}