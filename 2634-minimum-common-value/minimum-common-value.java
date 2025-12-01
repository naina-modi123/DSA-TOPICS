class Solution {
    public int bs(int[] nums2, int x){
        int low = 0;
        int high = nums2.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums2[mid] == x){
                return mid;
            }else if(nums2[mid] > x){
                high = mid- 1;
            }else{
                low = mid+1;
            }
        }
        return -1;

    }
    public int getCommon(int[] nums1, int[] nums2) {
        for(int i=0;i<nums1.length;i++){
            int x = nums1[i];
            int idx = bs(nums2, x);
            if(idx != -1){
                return x;
            }
        }
        return -1;
    }
}