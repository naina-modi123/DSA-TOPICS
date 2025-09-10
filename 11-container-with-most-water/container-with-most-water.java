class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int lp = 0, rp = n-1;
        int maxWater = 0;
        while(lp < rp){
            int w = rp - lp;
            int len = Math.min(height[lp],height[rp]);
            int currWater = w * len;
            maxWater = Math.max(maxWater , currWater);
            if(height[lp] < height[rp]){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxWater;
    }
}