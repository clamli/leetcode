class Solution {
    public String nextClosestTime(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> set = new HashSet<>();
        for (char ch : time.toCharArray()) {
            if (ch != ':') {
                set.add(ch-'0');
            }
        }
        int min = Integer.MAX_VALUE, mintime = 0, newtime = 0;
        for (int ch1 : set) {
            for (int ch2 : set) {
                if (ch1 * 10 + ch2 < 24) {
                    for (int ch3 : set) {
                        for (int ch4 : set) {
                            if (ch3 * 10 + ch4 < 60) {
                                newtime = (ch1 * 10 + ch2) * 60 + ch3 * 10 + ch4;
                                int diff = 0;
                                if (newtime <= cur) diff = newtime+1440-cur;
                                else diff = newtime-cur;
                                if (diff < min) {
                                    min = diff;
                                    mintime = newtime;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return String.format("%02d:%02d", mintime / 60, mintime % 60);
    }
}