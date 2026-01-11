class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for(int[] trip : trips){
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += passenger;
            diff[to] -= passenger;
        }
        int currPassenger = 0;
        for(int i=0;i<diff.length;i++){
            currPassenger += diff[i];
            if(currPassenger > capacity){
                return false;
            }
        }
        return true;
    }
}