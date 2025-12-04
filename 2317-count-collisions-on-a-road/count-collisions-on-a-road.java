class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0, j = n-1;
        char[] dir = directions.toCharArray();
        while(i<n && dir[i] == 'L'){
            i++;
        }
        while(j >=0 && dir[j] == 'R'){
            j--;
        }
        int coll = 0;
        for(int m = i;m <= j;m++){
            if(dir[m] == 'L' || dir[m] == 'R'){
                coll++;
            }
        }
        return coll;
    }
}