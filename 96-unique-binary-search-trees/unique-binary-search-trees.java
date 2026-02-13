class Solution {
    public int numTrees(int n) {
         int[] uniqueBSTCount = new int[n + 1];

        uniqueBSTCount[0] = 1; 
        uniqueBSTCount[1] = 1; 
        for (int nodes = 2; nodes <= n; nodes++) {

            int totalWays = 0;

            for (int root = 1; root <= nodes; root++) {

                int leftSubtreeNodes = root - 1;
                int rightSubtreeNodes = nodes - root;

                int leftWays = uniqueBSTCount[leftSubtreeNodes];
                int rightWays = uniqueBSTCount[rightSubtreeNodes];

                totalWays += leftWays * rightWays;
            }

            uniqueBSTCount[nodes] = totalWays;
        }

        return uniqueBSTCount[n];
    }
}