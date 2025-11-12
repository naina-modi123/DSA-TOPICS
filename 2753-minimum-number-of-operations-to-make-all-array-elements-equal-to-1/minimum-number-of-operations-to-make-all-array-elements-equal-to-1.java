class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        for(int num : nums){
            if(num == 1) countOnes++;
        }

        if(countOnes > 0){
            return (n- countOnes);
        }

        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int currGCD = nums[i];
            for(int j=i+1;j<n;j++){
                currGCD = gcd(currGCD, nums[j]);
                if(currGCD == 1){
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        }
        if(minLen == Integer.MAX_VALUE) return -1;
        return (minLen - 1)+(n-1);
        
    }
    private int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }
}