class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = getMaxConsecutive(hBars);
        int maxV = getMaxConsecutive(vBars);
        int side = Math.min(maxH, maxV);
        return side*side; 
    }
    private int getMaxConsecutive(int [] bars){
        Arrays.sort(bars);
        int currLen = 1;
        int maxLen = 1;
        for(int i=1;i<bars.length;i++){
            if(bars[i] == bars[i-1] + 1){
                currLen++;
            }else{
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen+1;
    }
}