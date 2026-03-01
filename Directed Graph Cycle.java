class Solution {
    private static boolean dfs(int node, int[] vis, int[] pathVis, List<List<Integer>> adjList){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int nbr : adjList.get(node)){
            if(vis[nbr] == 0){
                if(dfs(nbr, vis, pathVis, adjList) == true) return true;
            }else if(pathVis[nbr] != 0){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(i, vis, pathVis, adjList) == true) return true;
            }
        }
        return false;
    }
}
