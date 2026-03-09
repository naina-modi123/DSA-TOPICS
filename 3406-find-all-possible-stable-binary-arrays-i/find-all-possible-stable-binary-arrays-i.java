class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;

        long[][] dp0 = new long[zero + 1][one + 1];
        long[][] dp1 = new long[zero + 1][one + 1];

        for(int i = 1; i <= Math.min(zero, limit); i++){
            dp0[i][0] = 1;
        }

        for(int j = 1; j <= Math.min(one, limit); j++){
            dp1[0][j] = 1;
        }

        for(int z = 0; z <= zero; z++){
            for(int o = 0; o <= one; o++){
                if(z > 0){
                    for(int k = 1; k <= limit && z - k >= 0; k++){
                        dp0[z][o] = (dp0[z][o] + dp1[z - k][o]) % MOD;
                    }
                }
                if(o > 0){
                    for(int k = 1; k <= limit && o - k >= 0; k++){
                        dp1[z][o] = (dp1[z][o] + dp0[z][o - k]) % MOD;
                    }
                }
            }
        }
        return (int)((dp0[zero][one] + dp1[zero][one]) % MOD);
    }
}