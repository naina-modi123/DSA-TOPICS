class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = (i ^ seq.charAt(i)) & 1;
        }
        return ans;
    }
}
