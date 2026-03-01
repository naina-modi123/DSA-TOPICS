class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int prerequisite[] : prerequisites){
            adjList.get(prerequisite[0]).add(prerequisite[1]);
            indegree[prerequisite[1]]++;
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
        if(ans.size() == numCourses) return true;
        else return false;
    }
}