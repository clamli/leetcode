class Solution {
    public int candy(int[] ratings) {
        int countDown = 0, prev = 1, total = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i-1]) {
                countDown++;
            } else {
                if (countDown > 0) {
                    total += countDown*(countDown + 1) / 2;
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i-1] ? 1 : prev+1;
                total += prev;
            }
        }
        if (countDown > 0) {
            total += countDown*(countDown + 1) / 2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
    }
}