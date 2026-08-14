class Solution {
    public int findContentChildren(int[] greed, int[] cookies) {
        int n = cookies.length;
        int m = greed.length;
        int gl=0,cl=0;
        Arrays.sort(greed);
        Arrays.sort(cookies);
        while(cl < n && gl < m){
            if(cookies[cl] >= greed[gl]){
                cl++;gl++;
            }else{
                cl++;
            }
        }
        return gl;
        
    }
}
