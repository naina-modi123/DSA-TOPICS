class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] square = new long[n];
        for (int i = 0; i < n; i++) {
            square[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(square);
        long ans = 0;
        int pos = (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            if (i < pos) ans += square[n - 1 - i];
            else ans -= square[n - 1 - i];
        }
        return ans;
    }
}
