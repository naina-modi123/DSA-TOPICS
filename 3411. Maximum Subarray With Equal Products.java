class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int product = 1, left = 0, best = 2;
        for(int right = 0;right < n;right++){
            int x = nums[right];
            while(gcd(product, x) > 1){
                product /= nums[left++];
            }
            product *= x;
            best = Math.max(best, right-left+1);
        }
        return best;
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
}
