class Solution {

    private int lcs_spo(String t1, String t2){
        int n = t1.length();
        int m = t2.length();
        int[] curr = new int[m+1];
        int[] next = new int[m+1];
        for(int i= n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(t1.charAt(i) == t2.charAt(j)){
                    curr[j] = next[j+1]+1;
                }
                else{
                    curr[j] = Math.max(curr[j+1], next[j]);
                }
            }
            next = curr.clone();
        }
        return curr[0];
    }
    public int minDistance(String word1, String word2) {
        int x = lcs_spo(word1, word2);
        return word1.length()+word2.length()-2*x;
        
    }
}