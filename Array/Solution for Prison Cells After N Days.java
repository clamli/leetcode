class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        List<int[]> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int cell : cells) {
            sb.append(cell);
        }
        map.put(sb.toString(), 0);
        lst.add(cells);
        int rot = 0, st = 0;
        while (true) {
            int[] value = new int[cells.length];
            sb = new StringBuilder();
            sb.append('0');
            for (int j = 1; j < cells.length-1; j++) {
                if (cells[j-1] == cells[j+1]) {
                    value[j] = 1;
                    sb.append('1');
                }
                else sb.append('0');
            }
            sb.append('0');
            String key = sb.toString();
            if (map.containsKey(key)){
                st = map.get(key);
                rot = rot - map.get(key) + 1;
                break;
            } 
            rot++;
            map.put(key, rot);
            lst.add(value);
            cells = value;
        }
        int mod = (N-st) % (rot);
        return lst.get(st+mod);
    }
}