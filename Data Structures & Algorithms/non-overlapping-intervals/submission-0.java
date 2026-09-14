class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by minimum ending point
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        System.out.println(Arrays.deepToString(intervals));

        int end = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {

            // if there is an overlap increase the count
            if (intervals[i][0] < end)
                result++;

            // else increment the ending point
            else
                end = intervals[i][1];
        }

        // return the count
        return result;
    }
}
