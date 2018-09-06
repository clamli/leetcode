class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int[][] stack = new int[logs.size()][2];   // fuc id : start time
        int ptn = 0;
        for (String log : logs) {
            String[] info = log.split(":");
            int fucid = Integer.parseInt(info[0]);
            String stage = info[1];
            int time = Integer.parseInt(info[2]);
            if (stage.equals("start")) {
                if (ptn > 0)
                    res[stack[ptn-1][0]] += time - stack[ptn-1][1];
                stack[ptn][0] = fucid;
                stack[ptn][1] = time;
                ptn++;
            } else if (stage.equals("end")) {
                res[stack[ptn-1][0]] += time - stack[ptn-1][1] + 1;
                ptn--;
                if (ptn > 0)
                    stack[ptn-1][1] = time + 1;
            }
        }
        return res;
    }
}