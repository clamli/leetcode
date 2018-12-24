class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int a : A) {
            if (set.contains(a)) {
                result = a;
                break;
            }
            set.add(a);
        }
        return result;
    }
}