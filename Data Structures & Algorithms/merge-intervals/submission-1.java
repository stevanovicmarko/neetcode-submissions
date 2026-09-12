class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        var result = new ArrayList<int[]>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = result.getLast()[0];
            int currentEnd = result.getLast()[1];

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                // has overlap
                result.set(result.size() - 1,
                    new int[] {Math.min(currentStart, nextStart), Math.max(currentEnd, nextEnd)});
            } else {
                // no overlap
                result.add(new int[] {nextStart, nextEnd});
            }
        }

        return result.toArray(new int[0][0]);
    }
}
