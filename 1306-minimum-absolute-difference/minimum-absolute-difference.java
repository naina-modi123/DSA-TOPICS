class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;;
        for(int i=1;i<n;i++){
            int curr_minAbsDiff = arr[i] - arr[i-1];
            if(curr_minAbsDiff < minAbsDiff){
                minAbsDiff = curr_minAbsDiff;
            }
        }
        for(int i=1;i<n;i++){
            if(arr[i] - arr[i-1] == minAbsDiff){
                List<Integer> subAns = new ArrayList<>();
                subAns.add(arr[i-1]);
                subAns.add(arr[i]);
                ans.add(subAns);
            }
        }
        return ans;
    }
}