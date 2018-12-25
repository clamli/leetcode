class Solution {
    public int hammingDistance(int x, int y) {
        List<Integer> resx = new ArrayList<>();
        List<Integer> resy = new ArrayList<>();
        while (x != 0) {
            resx.add(x%2);
            x /= 2;
        }
        while (y != 0) {
            resy.add(y%2);
            y /= 2;
        }
        int dist = 0, i, upp = Math.min(resx.size(), resy.size());
        for (i = 0; i < upp; i++) {
            if (resx.get(i) != resy.get(i)) dist++;
        }
        while (i < resx.size()) {
            if (resx.get(i++) == 1) dist += 1;
        }
        while (i < resy.size()) {
            if (resy.get(i++) == 1) dist += 1;
        }
        return dist;
        
        // return x^y;
    }
}