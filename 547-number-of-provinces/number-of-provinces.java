class Solution {
    private void dfs(int node, List<List<Integer>> adjList, int[] vis){
        vis[node] = 1;
        for(int nbr : adjList.get(node)){
            if(vis[nbr] == 0){
                vis[nbr] = 1;
                dfs(nbr, adjList, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i != j && isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                }
            }
        }
        int ans = 0;
        int[] vis = new int[N];
        for(int i=0;i<N;i++){
            if(vis[i] == 0){
                ans += 1;
                dfs(i, adjList, vis);
            }
        }
        return ans;
    }
}