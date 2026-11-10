class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var pq = new PriorityQueue<int[]>((p1, p2) -> {
            long d1 = (long) p1[0] * p1[0] + (long) p1[1] * p1[1];
            long d2 = (long) p2[0] * p2[0] + (long) p2[1] * p2[1];
            return Long.compare(d2, d1);
        });
        
        for (int[] point: points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        var result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
