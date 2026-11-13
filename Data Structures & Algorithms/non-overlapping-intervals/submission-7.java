class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        System.out.println((Arrays.deepToString(intervals)));
        int result = 0;
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (currentEnd > nextStart) {
                // overlap
                result++;
            } else {
currentEnd = nextEnd;
            }
            
        }
        return result;
    }
}
