class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < n; i++) {
                if (original == nums[i]) {
                    original = 2 * original;
                    flag = true;
                    break;
                }
            }
        }
        return original;
    }
}