class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] == nums[j] && (!result.contains(nums[i]))){
                    result.add(nums[i]);
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}