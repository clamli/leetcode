class Solution {
    // O(N^2)
    // public int totalFruit(int[] tree) {
    //     int max = 0;
    //     for (int i = 0; i < tree.length; i++) {
    //         int j;
    //         Set<Integer> set = new HashSet<>();
    //         for (j = i; j < tree.length; j++) {
    //             set.add(tree[j]);
    //             if (set.size() > 2) break;
    //         }
    //         max = Math.max(max, j - i);
    //     }
    //     return max;
    // }
    
    // O(N)
    public int totalFruit(int[] tree) {
        int left = 0, right = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < tree.length) {
            map.put(tree[right], map.getOrDefault(tree[right], 0)+1);
            if (map.size() > 2) {
                max = Math.max(max, right-left);
                while (map.size() > 2) {
                    map.put(tree[left], map.get(tree[left])-1);
                    if (map.get(tree[left]) == 0) {
                        map.remove(tree[left]);
                    }
                    left++;
                }
            }
            right++;
        }
        max = Math.max(max, right-left);
        return max;
    }
}