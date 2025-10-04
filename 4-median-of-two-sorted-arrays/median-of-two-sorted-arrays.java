class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums3 = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        
        // Merge arrays
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        while(i < n1) nums3[k++] = nums1[i++];
        while(j < n2) nums3[k++] = nums2[j++];
        
        // Find median
        int total = n1 + n2;
        if(total % 2 == 0) {
            return (nums3[total/2 - 1] + nums3[total/2]) / 2.0;
        } else {
            return nums3[total/2];
        }
    }
}
