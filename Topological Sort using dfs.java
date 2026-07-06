class Solution {
    private void dfs(int node, int[] vis, List<List<Integer>> adj,Stack<Integer> st){
        vis[node] = 1;
        for(int nbr : adj.get(node)){
            if(vis[nbr] == 0){
                dfs(nbr, vis, adj, st);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(st.size() > 0){
            ans.add(st.pop());
        }
        return ans;
    }
}
