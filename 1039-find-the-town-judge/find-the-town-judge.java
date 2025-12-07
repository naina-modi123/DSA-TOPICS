class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] iD = new int[n + 1];
        int[] oD = new int[n + 1];

        for (int[] x : trust){
            int a = x[0];
            int b = x[1];

            oD[a]++;  
            iD[b]++;
        }
        for (int person = 1; person <= n; person++) {
            if (iD[person] == n - 1 && oD[person] == 0) {
                return person;
            }
        }
        return -1;
    }
}
