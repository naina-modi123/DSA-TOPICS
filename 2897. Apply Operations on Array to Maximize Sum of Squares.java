class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long mod = 1000000007;
        int[] count = new int[30];
        for(int x : nums){
            for(int b = 0;b<30;b++){
                count[b] += x >> b & 1;
            }
        }
        long total = 0;
        for(int i=0;i<k;i++){
            long row = 0;
            for(int b=0;b<30;b++){
                if(count[b] > i) row |= 1L << b;
            }
            total = (total+row *row) % mod;
        }
        return (int) total;
    }
}
