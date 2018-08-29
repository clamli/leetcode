class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> ele, List<Integer> idx, List<List<Integer>> res) {
        if (ele.size() == nums.length) {
            res.add(new ArrayList<>(ele));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (idx.contains(i) || used.contains(nums[i])) continue;
            used.add(nums[i]);
            ele.add(nums[i]);
            idx.add(i);
            backtrack(nums, ele, idx, res);
            ele.remove(ele.size()-1);
            idx.remove(idx.size()-1);
        }
    }
}