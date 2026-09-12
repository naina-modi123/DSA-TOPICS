class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = helper(dvd, dvs);

        if((dividend < 0)^(divisor < 0))
            result = -result;

        return result;
    }
    private int helper(long dvd, long dvs){
        if (dvd < dvs) return 0;
        long sum = dvs;
        int multiple = 1;
        while((sum + sum) <= dvd){
            sum += sum;
            multiple += multiple;
        }
        return multiple + helper(dvd - sum, dvs);
    }
}
