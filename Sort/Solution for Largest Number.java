class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }        
        
        Comparator<String> compare = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                String comp1 = str1 + str2;
                String comp2 = str2 + str1;
                return comp2.compareTo(comp1);
            }
        };
        
        Arrays.sort(strNums, compare);
        if (strNums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        return sb.toString();
    }
}