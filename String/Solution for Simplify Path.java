class Solution {
    public String simplifyPath(String path) {
        Stack<String> S = new Stack<>();
        int pt = 0, len = path.length();
        while (pt < len) {
            if (Character.isLetter(path.charAt(pt))) {
                int ed = pt;
                while (++ed < len && path.charAt(ed) != '/');
                S.push(path.substring(pt, ed));
                pt = ed;
            } else if (path.charAt(pt) == '.') {
                int ed = pt;
                while (++ed < len && path.charAt(ed) != '/');
                int cnt = ed - pt;
                String str = path.substring(pt, ed);
                if (cnt == 2 && str.equals("..") && !S.isEmpty()) {
                    S.pop();
                } else if (cnt > 2) {
                    S.push(str);
                }
                pt = ed;
            } else {
                pt++;
            }
        }
        List<String> list = new ArrayList<>();
        while (!S.isEmpty()) {
            list.add(S.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append('/');
            sb.append(list.get(i));
        }
        if (sb.length() == 0) sb.append('/');
        return sb.toString();
    }
}