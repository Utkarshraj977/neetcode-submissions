class KthLargest {
    int size;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > size) {
                pq.remove();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > size) {
            pq.remove();
        }
        return pq.peek();
    }
}
