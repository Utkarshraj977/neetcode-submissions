class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        helper(nums, ans, t, 0);
        return ans;
    }

    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> t, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[i]);
        helper(nums, ans, t, i + 1);
        t.remove(t.size() - 1);
        helper(nums, ans, t, i + 1);
    }
}
