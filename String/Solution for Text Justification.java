class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int accum = 0, sum = words[i].length();
            List<String> sentence = new ArrayList<>();
            while (sum <= maxWidth) {
                accum = sum;
                sentence.add(words[i]);
                i++;
                if (i > words.length - 1) break;
                sum += 1 + words[i].length();
            }
            i--;
            StringBuilder sb = new StringBuilder();
            int num = sentence.size() - 1;
            if (i == words.length-1 || num == 0) {
                for (int j = 0; j < num; j++) {
                    sb.append(sentence.get(j));
                    sb.append(' ');
                }
                sb.append(sentence.get(num));
            } else {
                int blanks = maxWidth - accum, itv = 0, j, nitv = num;
                sb.append(sentence.get(0));
                for (j = 1; j <= num; j++) {
                    if (blanks % nitv == 0) {
                        itv = blanks / nitv;
                        break;
                    } else {
                        sb.append(' ');
                        itv = blanks / nitv + 1;
                        blanks -= itv;
                        nitv--;
                        for (int t = 0; t < itv; t++) sb.append(' ');
                        sb.append(sentence.get(j));
                    }
                }
                for (int t = j; t <= num; t++) {
                    sb.append(' ');
                    for (int k = 0; k < itv; k++) sb.append(' ');
                    sb.append(sentence.get(t));
                }
            }
            for (int j = sb.length(); j < maxWidth; j++) {
                sb.append(' ');
            }
            res.add(sb.toString());
        }
        return res;
    }
}