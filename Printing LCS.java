private int lcs_tab(int n, int m, String t1, String t2, int[][] dp){
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(t1.charAt(i) == t2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        int i=0,j = 0;
        StringBuilder ans = new StringBuilder();
        while(i < n && j < m){
            if(t1.charAt(i) == t2.charAt(j)){
                ans.append(t1.charAt(i));
                i++;
                j++;
            }
            else if(dp[i+1][j] >= dp[i][j+1]){
                i++;
            }
            else{
                j++;
            }
        }
        System.out.println(ans.toString());
        return dp[0][0];
    }
