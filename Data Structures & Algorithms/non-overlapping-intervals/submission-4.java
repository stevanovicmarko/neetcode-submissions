class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        //System.out.println(Arrays.deepToString(intervals));

        int currentEnd = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            int nextIntervalBeginning = intervals[i][0];
            int nextIntevalEnd = intervals[i][1];
            if (nextIntervalBeginning < currentEnd) {
                result++;
            } else {
                currentEnd = nextIntevalEnd;
            }
        }

        return result;
    }
}
