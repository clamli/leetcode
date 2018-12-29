class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
            degree.put(i, 0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            degree.put(prerequisites[i][0], degree.get(prerequisites[i][0])+1);
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree.get(i) == 0) Q.offer(i);
        }
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while (!Q.isEmpty()) {
            int course = Q.poll();
            list.add(course);
            for (int aft : graph.get(course)) {
                degree.put(aft, degree.get(aft)-1);
                if (degree.get(aft) == 0) Q.offer(aft);
            }
        }
        if (list.size() != numCourses) return new int[0];
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = list.get(i);
        }
        return  result;
    }
} 