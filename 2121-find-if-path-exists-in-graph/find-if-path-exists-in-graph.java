class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adjList, visited);
    }

    private boolean dfs(int node, int destination, List<List<Integer>> adjList, boolean[] visited) {
        if (node == destination) return true;

        visited[node] = true;
        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, destination, adjList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
