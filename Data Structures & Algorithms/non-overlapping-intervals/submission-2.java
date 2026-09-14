class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        //System.out.println(Arrays.deepToString(intervals));

        int end = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            int nextIntervalBegining = intervals[i][0];
            int nextIntevalEnd = intervals[i][1];
            if (nextIntervalBegining < end) {
                result++;
            } else {
                end = nextIntevalEnd;
            }
        }

        return result;
    }
}
