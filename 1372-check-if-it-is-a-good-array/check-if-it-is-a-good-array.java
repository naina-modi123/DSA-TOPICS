class Solution {
    public boolean isGoodArray(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n = gcd(n, nums[i]);
            if (n == 1) return true;
        }
        return n == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
