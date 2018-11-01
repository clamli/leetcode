class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timePointsInt = new ArrayList<>();
        for (String time : timePoints) {
            int sidx = time.indexOf(':'), timeInt = Integer.parseInt(time.substring(0, sidx)) * 60 + Integer.parseInt(time.substring(sidx+1));
            timePointsInt.add(timeInt);
        }
        Collections.sort(timePointsInt);
        int mindiff = timePointsInt.get(0) + 1440 - timePointsInt.get(timePointsInt.size()-1);
        for (int i = 1; i < timePointsInt.size(); i++) {
            mindiff = Math.min(mindiff, timePointsInt.get(i) - timePointsInt.get(i-1));
        }
        return mindiff;
    }
}