class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        int operation = 0;
        while(!isIncreasing(list)){
            int minSum = Integer.MAX_VALUE;
            int idx = 0;
            for(int i=0;i<list.size()-1;i++){
                int sum = list.get(i) + list.get(i+1);
                if(sum < minSum){
                    minSum = sum;
                    idx = i;
                }
            }
            list.remove(idx);
            list.remove(idx);
            list.add(idx, minSum);
            operation++;
        }
        return operation;
        
    }
    private boolean isIncreasing(List<Integer> list) {
        for(int i = 1;i < list.size();i++){
            if(list.get(i) < list.get(i-1)) return false;
        }
        return true;
    }
}