class Solution {
    private void dfs(int node, int[] vis, List<List<Integer>> adj){
        vis[node] = 1;
        for(int nbr : adj.get(node)){
            if(vis[nbr] == 0){
                dfs(nbr, vis, adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        int ans = 0;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                ans += 1;
                dfs(i, vis, adj);
            }
        }
        return ans;
        
    }
}