class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int num: nums) {
            map.merge(num, 1, Integer::sum);
        }
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        for (var entry: map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue() });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;

    }
}
