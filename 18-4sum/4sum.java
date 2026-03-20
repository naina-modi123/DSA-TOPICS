class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i > 0 && (nums[i] == nums[i-1])) continue;
            for(int j=i+1;j<n-2;j++){
                if(j > i+1 && (nums[j] == nums[j-1])) continue;
                int k = j+1;
                int w = n-1;

                while(k < w){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[w];

                    if(sum == target){
                        List<Integer> subans = new ArrayList<>();
                        subans.add(nums[i]);
                        subans.add(nums[j]);
                        subans.add(nums[k]);
                        subans.add(nums[w]);
                        ans.add(subans);

                        k++;
                        w--;
                        while(k < w && (nums[k] == nums[k-1])) k++;
                        while(k < w && (nums[w] == nums[w+1])) w--;

                    }else if(sum < target){
                        k++;
                    }else{
                        w--;
                    }
                }
            }
        }
        return ans;
    }
}