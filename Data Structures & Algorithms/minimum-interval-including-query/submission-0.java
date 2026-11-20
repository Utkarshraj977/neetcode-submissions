class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int qlen = queries.length;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] quer = new int[qlen][2];
        for (int i = 0; i < qlen; i++) {
            quer[i][0] = queries[i];
            quer[i][1] = i;
        }
        Arrays.sort(quer,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] result=new int[qlen];
        int i=0;

        for (int[] q : quer) {
            int query=q[0];
            int originalidx=q[1];

            while (i < n && intervals[i][0] <= query) {
                int st = intervals[i][0];
                int end = intervals[i][1];
                int size = end-st+1;
                pq.add(new int[]{size,end});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < query) pq.remove();

            result[originalidx]=pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return result;
    }
}
