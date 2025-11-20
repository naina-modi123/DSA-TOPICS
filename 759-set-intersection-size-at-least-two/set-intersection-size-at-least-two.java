class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });

        int p1 = -1, p2 = -1;
        int count = 0;

        for (int[] in : intervals) {
            int start = in[0];
            int end = in[1];

            if (start <= p2) {
                continue;
            } else if (start <= p1) {
                count += 1;
                p2 = p1;
                p1 = end;
            } else {
                count += 2;
                p2 = end - 1;
                p1 = end;
            }
        }
        return count;
    }
}
