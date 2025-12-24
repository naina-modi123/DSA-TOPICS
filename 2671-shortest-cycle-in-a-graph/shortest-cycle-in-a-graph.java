class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int[] dist = new int[n];
            int[] par = new int[n];
            Arrays.fill(dist, -1);
            Arrays.fill(par, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            dist[i] = 0;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int nbr : adj.get(cur)){
                    if(dist[nbr] == -1){
                        dist[nbr] = dist[cur] + 1;
                        par[nbr] = cur;
                        q.add(nbr);
                    }
                    else if(nbr != par[cur]){
                        int len = dist[cur] + dist[nbr] + 1;
                        ans = Math.min(ans, len);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;   
    }
}