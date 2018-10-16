class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> values_m = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            if (!pairs.containsKey(equations[i][0])) {
                pairs.put(equations[i][0], new ArrayList<>());
                values_m.put(equations[i][0], new ArrayList<>());
            }
            if (!pairs.containsKey(equations[i][1])) {
                pairs.put(equations[i][1], new ArrayList<>());
                values_m.put(equations[i][1], new ArrayList<>());
            }
            pairs.get(equations[i][0]).add(equations[i][1]);
            pairs.get(equations[i][1]).add(equations[i][0]);
            values_m.get(equations[i][0]).add(values[i]);
            values_m.get(equations[i][1]).add(1/values[i]);
        }
        double result[] = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!pairs.containsKey(queries[i][0]) || !pairs.containsKey(queries[i][1])) result[i] = -1.0;
            else {
                result[i] = getRes(pairs, values_m, queries[i][0], queries[i][1], 1.0, new HashSet<>());
                result[i] = result[i] == 0 ? -1.0 : result[i];
            }
        }
        return result;
    }
    
    private double getRes(Map<String, List<String>> pairs, Map<String, List<Double>> values, String start, String end, double ret, Set<String> visited) {
        if (start.equals(end)) return ret;
        double result = 0;
        for (int i = 0; i < pairs.get(start).size(); i++) {
            if (!visited.contains(pairs.get(start).get(i))) {
                visited.add(pairs.get(start).get(i));
                result = getRes(pairs, values, pairs.get(start).get(i), end, ret*values.get(start).get(i), visited);
                if (result != 0) break;
                visited.remove(visited.size()-1);
            }
        }
        return result;
    }
}