class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap <Integer,Integer> memo = new HashMap<>();
        int ans = helper(coins, amount,memo);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }
    private int helper(int[] coins, int amount, HashMap <Integer,Integer> memo){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(memo.containsKey(amount)) return memo.get(amount);
        int minVal = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = helper(coins, amount- coin, memo);
            if (res != Integer.MAX_VALUE){
                minVal = Math.min(minVal, res + 1);
            }
        }
        memo.put(amount, minVal);
        return minVal;
    }
}