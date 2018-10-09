class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> Q = new LinkedList<>();
        Q.offer(beginWord);
        int len = 0;
        Set<String> wordSet = new HashSet<>(wordList);
        while (!Q.isEmpty()) {
            int size = Q.size();
            len++;
            for (int i = 0; i < size; i++) {
                String curWord = Q.poll();
                if (curWord.equals(endWord)) {
                    return len;
                }
                char[] wordArr = curWord.toCharArray();
                for (int j = 0; j < curWord.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = wordArr[j];
                        wordArr[j] = c;
                        String target = String.valueOf(wordArr);
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            Q.offer(target);
                            visited.add(target);
                        }
                        wordArr[j] = old;
                    }
                }
            }
        }
        return 0;
    }
}