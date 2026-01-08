class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int num = nums[i];
            int more = target - num;
            if(map.containsKey(more)){
                ans[0] = map.get(more);
                ans[1] = i;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}