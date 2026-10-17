class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digitSum = new int[n];
        for(int i=0;i<n;i++){
            int num = nums[i];
            int sum = 0;
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            digitSum[i] = sum;
        }
        Integer[] indices = new Integer [n];
        for(int i=0;i<n;i++){
            indices[i] = i;
        }
        Arrays.sort(indices,(a, b) -> {
            if(digitSum[a] != digitSum[b]){
                return Integer.compare(digitSum[a], digitSum[b]);
            }
            return Integer.compare(nums[a], nums[b]);
        });
        int[] targetPos = new int[n];
        for(int i=0;i<n;i++){
            targetPos[indices[i]] = i;
        }

        boolean[] visited = new boolean[n];
        int cycle = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cycle++;
                int j = i;
                while(!visited[j]){
                    visited[j] = true;
                    j = targetPos[j];
                }
            }
        }
        return n-cycle;
    }
}
