class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String[] wordArray = paragraph.split("([.,!?;'\"-]|\\s)+");
        Map<String, Integer> wordcnt = new HashMap<>();
        int maxcnt = 0;
        String result = "";
        for (String word : wordArray) {
            word = word.toLowerCase();
            if (!bannedSet.contains(word)) {
                wordcnt.put(word, wordcnt.getOrDefault(word, 0)+1);
                if (wordcnt.get(word) > maxcnt) {
                    maxcnt = wordcnt.get(word);
                    result = word;
                }
            }
        }
        return result;
    }
}