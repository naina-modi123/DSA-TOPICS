class Solution {
    public int maxArea(int[] height) {
      int low = 0, high = height.length - 1;
      int maxArea = 0;
      while(low < high){
        int width = high - low;
        int length = Math.min(height[low], height[high]);
        int currArea = width*length;
        maxArea = Math.max(maxArea, currArea);
        if(height[low] < height[high]){
            low++;
        }
        else{
            high--;
        }
      }
      return maxArea;
    }
}