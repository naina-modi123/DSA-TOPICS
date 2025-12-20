class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int[] f : flights) {
            g.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0];
            int cost = cur[1];
            int stop = cur[2];

            if (stop > k) continue;

            for (int[] nb : g.get(u)) {
                int v = nb[0];
                int w = nb[1];

                if (cost + w < dis[v]) {
                    dis[v] = cost + w;
                    q.add(new int[]{v, dis[v], stop + 1});
                }
            }
        }
        if (dis[dst] == Integer.MAX_VALUE) {
         return -1;
        }
        return dis[dst];
    }
}