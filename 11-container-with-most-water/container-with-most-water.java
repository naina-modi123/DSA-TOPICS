class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int max_area = 0;
        while(left < right){
            int length = right - left;
            int breadth = Math.min(height[left], height[right]);
            int curr_area = length*breadth;
            max_area = Math.max(curr_area, max_area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max_area;
        
    }
}