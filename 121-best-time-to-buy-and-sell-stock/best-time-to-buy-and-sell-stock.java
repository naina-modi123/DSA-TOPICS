class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        for(int i=0;i<n;i++){
            int cost = prices[i] - buy;
            profit = Math.max(profit, cost);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }
}