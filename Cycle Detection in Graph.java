import java.util.*;
class Graph {
    private int v;                 
    private ArrayList<ArrayList<Integer>> adj; 

    Graph(int v) {
        this.v = v;
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    
    void addEdge(int x, int y) {
        adj.get(x).add(y);
        adj.get(x).add(y);
    }
    public boolean dfs(int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neigh : adj.get(node)){
            
            if (!visited[neigh]){
                if (dfs(neigh, node, visited)){
                    return true;    
                }
            }
            else if (neigh != parent) {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle() {
        boolean[] visited = new boolean[v];
        for (int i = 0; i<v; i++){
            if (!visited[i]){
                if (dfs(i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        if (g.isCycle()){
            System.out.println("Cycle Exists");
        }
        else{
            System.out.println("No Cycle Exists");
        }
    }
}
