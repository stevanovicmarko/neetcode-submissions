class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int val : nums) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.add(new int[] { entry.getValue(), entry.getKey() });
            if (pq.size() > k)
                pq.poll();
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
