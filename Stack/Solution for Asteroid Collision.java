class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0) return null;
        int res[] = new int[asteroids.length], idx = 0;
        res[0] = asteroids[0];
        for (int i  = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                res[++idx] = asteroids[i];
            } else {
                int size = -asteroids[i];
                while (idx >= 0 && res[idx] > 0) {
                    if (size < res[idx]) {
                        asteroids[i] = 0;
                        break;
                    } else if (size == res[idx]) {
                        idx--;
                        asteroids[i] = 0;
                        break;
                    } else {
                        idx--;
                    }
                }
                if (asteroids[i] != 0) {
                    res[++idx] = asteroids[i];
                }
            }
        }
        int[] resArr = new int[idx+1];
        for (int i = 0; i <= idx; i++) {
            resArr[i] = res[i];
        }
        return resArr;
    }
}