class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] fans = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int prerequisite[] : prerequisites){
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(q.size() > 0){
            int node = q.remove();
            ans.add(node);
            for(int nbr : adjList.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        if(ans.size() != numCourses) return new int[0];
        int i=0;
        for(int a : ans){
            fans[i] = a;
            i++;
        }
        return fans;
    }
}