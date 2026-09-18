class Solution {
    /**
     * @param {number[][]} intervals
     * @return {number[][]}
     */
    merge(intervals: number[][]): number[][] {
        intervals.sort((a, b) => a[0] - b[0]);

        const result = [intervals[0]];

        for (let i = 1; i < intervals.length; i++) {
            const [currentStart, currentEnd] = result[result.length - 1];
            const [nextStart, nextEnd] = intervals[i];

            if (currentEnd >= nextStart) {
                // no overlap
                result[result.length - 1] = [
                    currentStart,
                    Math.max(currentEnd, nextEnd),
                ];
            } else {
                // overlap
                result.push([nextStart, nextEnd]);
            }
        }

        return result;
    }
}
