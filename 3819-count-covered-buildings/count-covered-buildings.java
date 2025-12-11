class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> row = new HashMap<>();
        Map<Integer, TreeSet<Integer>> col = new HashMap<>();
        for(int[] b : buildings){
            int x = b[0];
            int y = b[1];
            row.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            col.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }
        int count = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            TreeSet<Integer> ys = row.get(x); 
            TreeSet<Integer> xs = col.get(y);    

            boolean left = ys.lower(y) != null;
            boolean right = ys.higher(y) != null;
            boolean above = xs.lower(x) != null;
            boolean below = xs.higher(x) != null;

            if (left && right && above && below) {
                count++;
            }
        }
        return count;
    }
}