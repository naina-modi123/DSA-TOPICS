class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int jumps = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < n - 1; i++) {
            r = Math.max(r, i + nums[i]);

            if (i == l) {
                jumps++;
                l = r;

                if (l >= n - 1)
                    break;
            }
        }
        return jumps;
    }
}
