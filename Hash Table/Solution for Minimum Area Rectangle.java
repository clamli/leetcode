class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[0])) map.put(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }
        int min_area = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    int area = Math.abs((p1[0]-p2[0])*(p1[1]-p2[1]));
                    min_area = Math.min(min_area, area);
                }
            }
        }
        return min_area == Integer.MAX_VALUE ? 0 : min_area;
    }
}