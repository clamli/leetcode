class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) map.put(flights[i][0], new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
        PQ.offer(new int[]{0, src, 0});
        while (!PQ.isEmpty()) {
            int[] cur = PQ.poll();
            if (cur[1] == dst) return cur[0];
            if (cur[2] <= K) {
                if (map.containsKey(cur[1])) {
                    for (int[] choi : map.get(cur[1])) {
                        PQ.offer(new int[]{cur[0]+choi[1], choi[0], cur[2]+1});
                    }
                }
            }
        }
        return -1;
    }
}