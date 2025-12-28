class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //better force
        int nums3[] = new int[m+n];
        int start1 = 0, start2 = 0, start3 = 0;
        while(start1 < m && start2 < n){
            if(nums1[start1] <= nums2[start2]){
                nums3[start3++] = nums1[start1++];
            }
            else{
                nums3[start3++] = nums2[start2++];
            }
        }
        while(start1 < m){
            nums3[start3++] = nums1[start1++];
        }
        while(start2 < n){
            nums3[start3++] = nums2[start2++];
        }
        for(int i=0;i<m+n;i++){
            nums1[i] = nums3[i];
        }
    }
}