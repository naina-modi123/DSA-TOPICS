class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i=0,j=1,k=0;
        
        while(i < n){
            if(k < n && nums[i] % 2 == 0){
                ans[k]= nums[i];
                k += 2;
            }else{
                if(j < n){
                    ans[j] = nums[i];
                    j += 2;
                }
            }
            i++;
        }
        return ans;
        
    }
}