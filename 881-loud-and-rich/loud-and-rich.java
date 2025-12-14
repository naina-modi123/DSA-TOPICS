class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] r : richer){
            int rich = r[0];
            int poor = r[1];
            adj.get(rich).add(poor);
            indegree[poor]++;
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = i;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rich = q.poll();
            for(int poor : adj.get(rich)){
                if(quiet[ans[rich]] < quiet[ans[poor]]){
                    ans[poor] = ans[rich];
                }
                indegree[poor]--;
                if(indegree[poor] == 0){
                    q.add(poor);
                }
            }
        }
        return ans;
    }
}