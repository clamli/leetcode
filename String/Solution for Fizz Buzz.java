class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int mod1 = i % 3, mod2 = i % 5;
            if (mod1 == 0 && mod2 == 0) {
                res.add("FizzBuzz");
            } else if (mod1 == 0) {
                res.add("Fizz");
            } else if (mod2 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}