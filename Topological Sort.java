class Solution {
    private void dfs(int node, int[] vis, List<List<Integer>> adjList, Stack<Integer> st){
        vis[node] = 1;
        for(int nbr : adjList.get(node)){
            if(vis[nbr] == 0){
                vis[nbr] = 1;
                dfs(nbr,vis, adjList, st);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            adjList.get(edge[0]).add(edge[1]);
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(i, vis, adjList, st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(st.size() > 0){
            ans.add(st.pop());
        }
        return ans;
    }
}
