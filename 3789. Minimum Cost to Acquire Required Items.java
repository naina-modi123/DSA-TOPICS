class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long pairs = Math.min(need1, need2);
        long costPairs = pairs*Math.min(cost1+cost2, costBoth);
        long rem1 = need1 - pairs;
        long rem2 = need2 - pairs;
        long costrem = rem1* Math.min(cost1, costBoth) + rem2 * Math.min(cost2, costBoth);
        return costPairs + costrem;
    }
}
