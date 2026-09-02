class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        boolean flag1 = false;
        for(int num : nums1){
            if(num % 2 == 0){
                flag1 = true;
            }
        }
        if(flag1 == true){
            return true;
        }
        boolean flag2 = false;
        for(int num : nums1){
            if(num % 2 == 1){
                flag2 = true;
            }
        }
        if(flag2 == true) return true;
        boolean flag3 = false;
        for(int i=0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(Math.abs(nums1[i] - nums1[j]) % 2 == 0 || Math.abs(nums1[i] - nums1[j]) % 2 == 1) {
                    flag3 = true;
                }
            }
        }
        if(flag3 == true) return true;
        else return false;
    }
}
