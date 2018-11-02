class Solution {
    // public int[][] reconstructQueue(int[][] people) {
    //     if (people.length == 0) return new int[0][0];
    //     Arrays.sort(people, new Comparator<int[]>(){
    //         @Override
    //         public int compare(int[] p1, int[] p2) {
    //             return p1[0] - p2[0];
    //         }
    //     });
    //     int[][] res = new int[people.length][people[0].length];
    //     for (int i = 0; i < res.length; i++) {
    //         for (int j = 0; j < res[0].length; j++) {
    //             res[i][j] = -1;
    //         }
    //     }
    //     for (int i = 0; i < people.length; i++) {
    //         int cnt = 0, j;
    //         for (j = 0; j < res.length; j++) {
    //             if (res[j][0] == -1) {
    //                 if (cnt == people[i][1]) break;
    //                 cnt++;
    //             }
    //             else if (res[j][0] >= people[i][0]) {
    //                 cnt++;
    //             }
    //         }
    //         res[j] = people[i];
    //     }
    //     return res;
    // }
    
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) return p1[1] - p2[1];
                return p2[0] - p1[0];
            }
        });
        List<int[]> lst = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            lst.add(people[i][1], people[i]);
        }
        int[][] res = new int[people.length][people[0].length];
        for (int i = 0; i < lst.size(); i++) {
            res[i] = lst.get(i);
        }
        return res;
    }
}