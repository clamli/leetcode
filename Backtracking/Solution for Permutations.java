class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> ele, List<List<Integer>> res) {
        if (ele.size() == nums.length) {
            res.add(new ArrayList<>(ele));
            return;
        }
        for (Integer num : nums) {
            if (ele.contains(num)) continue;
            ele.add(num);
            helper(nums, ele, res);
            ele.remove(num);
        }
    }
}