class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums3 [] = new int[m+n];
        int left = 0, right = 0, index = 0;
        while(left < m && right < n){
            if(nums1[left] <= nums2[right]){
                nums3[index++] = nums1[left++];
            }
            else{
                nums3[index++] = nums2[right++];
            }
        }
        while(left < m){
            nums3[index++] = nums1[left++];
        }
        while(right < n){
            nums3[index++] = nums2[right++];
        }
        for(int i=0;i<m+n;i++){
            nums1[i] = nums3[i];
        }
        
    }
}