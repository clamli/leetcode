class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(A);
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        for (int a : A) {
            if (map.get(a) != 0) {
                if (a < 0) {
                    if (a % 2 != 0 || !map.containsKey(a/2) || map.get(a/2) == 0) return false;
                    map.put(a, map.get(a)-1);
                    map.put(a/2, map.get(a/2)-1);
                } else {
                    if (!map.containsKey(2*a) || map.get(2*a) == 0) return false;
                    map.put(a, map.get(a)-1);
                    map.put(2*a, map.get(2*a)-1);
                }
            }
        }
        return true;
    }
}