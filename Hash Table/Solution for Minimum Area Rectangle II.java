class Solution {
    public double minAreaFreeRect(int[][] points) {
        Map<String, List<int[]>> recs = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double midX = (points[i][0] + points[j][0]) / 2.0;
                double midY = (points[i][1] + points[j][1]) / 2.0;
                double lens = (points[i][0] - points[j][0])*(points[i][0] - points[j][0])+(points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                String key = midX + " " + midY + " " + lens;
                if (!recs.containsKey(key)) recs.put(key, new ArrayList<>());
                recs.get(key).add(new int[]{i, j});
            }
        }
        double min_area = Double.MAX_VALUE;
        for (String key : recs.keySet()) {
            List<int[]> ps = recs.get(key);
            if (ps.size() < 2) continue;
            for (int i = 0; i < ps.size(); i++) {
                for (int j = i+1; j < ps.size(); j++) {
                    int[] p1 = points[ps.get(i)[0]];
                    int[] p2 = points[ps.get(j)[0]];
                    int[] p3 = points[ps.get(j)[1]];
                    double len1 = Math.sqrt((p1[0] - p2[0])*(p1[0] - p2[0]) + (p1[1] - p2[1])*(p1[1] - p2[1]));
                    double len2 = Math.sqrt((p1[0] - p3[0])*(p1[0] - p3[0]) + (p1[1] - p3[1])*(p1[1] - p3[1]));
                    double area = len1 * len2;
                    min_area = Math.min(min_area, area);
                }
            }
        }
        return min_area == Double.MAX_VALUE ? 0 : min_area;
    }
}