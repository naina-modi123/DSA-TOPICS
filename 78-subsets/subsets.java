class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans, subAns);
        return ans;
    }
    public static void helper(int idx, int[] nums, List<List<Integer>> ans, List<Integer> subAns){
        if(idx == nums.length){
            ans.add(new ArrayList<>(subAns));
            return;
        }
        subAns.add(nums[idx]);
        helper(idx+1, nums, ans, subAns);
        subAns.remove(subAns.size() - 1);
        helper(idx+1, nums, ans, subAns);
    }
}