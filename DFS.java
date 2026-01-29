class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        int[] vis = new int[n];
        helper_dfs(0,vis, ans, adj);
        return ans;
    }
    private void helper_dfs(int node, int[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        ans.add(node);
        for(int nbr : adj.get(node)){
            if(vis[nbr] == 0){
                helper_dfs(nbr, vis, ans, adj);
            }
        }
    }
}
