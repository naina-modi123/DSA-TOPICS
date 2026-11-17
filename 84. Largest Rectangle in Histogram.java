class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        for(int i=0;i<n;i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                minHeight = Math.min(minHeight,heights[j]);
                maxArea = Math.max(maxArea,minHeight*(j-i+1));
            }
        }
        return maxArea;
    }
}
