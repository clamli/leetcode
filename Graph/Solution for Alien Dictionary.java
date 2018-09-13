class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!degree.containsKey(ch)) degree.put(ch, 0);
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            String first = words[i];
            String second = words[i+1];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                char ch1 = first.charAt(j), ch2 = second.charAt(j);
                if (ch1 != ch2) {
                    Set<Character> set = map.containsKey(ch1) ? map.get(ch1) : new HashSet<>();
                    if (!set.contains(ch2)) {
                        set.add(ch2);
                        degree.put(ch2, degree.get(ch2)+1);
                        map.put(ch1, set);
                    }
                    break;
                }
            }
        }
        Queue<Character> Q = new LinkedList<>();
        for (char ch : degree.keySet()) {
            if (degree.get(ch) == 0) Q.offer(ch);
        }
        StringBuilder result = new StringBuilder("");
        while (!Q.isEmpty()) {
            char ch = Q.poll();
            result.append(ch);
            if (map.containsKey(ch)) {
                for (char mindeg : map.get(ch)) {
                    degree.put(mindeg, degree.get(mindeg)-1);
                    if (degree.get(mindeg) == 0) {
                        Q.offer(mindeg);
                    }
                }
            }
        }
        return result.length() == degree.size() ? result.toString() : "";
    }
}