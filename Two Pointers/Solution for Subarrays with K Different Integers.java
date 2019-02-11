class Solution {
    // public int subarraysWithKDistinct(int[] A, int K) {
    //     int n = A.length, result = 0;
    //     for (int i = 0; i <= n - K; i++) {
    //         int count = 0;
    //         int map[] = new int[20001];
    //         for (int j = i; j < n; j++) {
    //             if (map[A[j]] == 0) {
    //                 map[A[j]]++;
    //                 count++;
    //             }
    //             if (count == K) result++;
    //             else if (count > K) break;
    //         }
    //     }
    //     return result;
    // }
    
    
    public int subarraysWithKDistinct(int[] A, int K) {
        return fineAtMostK(A, K) - fineAtMostK(A, K - 1);
    }
    
    private int fineAtMostK(int[] A, int K) {
        int result = 0, n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < n) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            while (left <= right && map.size() > K) {
                map.put(A[left], map.getOrDefault(A[left], 0) - 1);
                if (map.get(A[left]) == 0) map.remove(A[left]);
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}