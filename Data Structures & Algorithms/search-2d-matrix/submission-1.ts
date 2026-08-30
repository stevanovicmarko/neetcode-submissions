class Solution {
    /**
     * @param {number[][]} matrix
     * @param {number} target
     * @return {boolean}
     */
    searchMatrix(matrix: number[][], target: number): boolean {
        let low = 0;
        let high = (matrix[0].length * matrix.length) - 1;
        let mid;

        while(low <= high) {
            mid = low + Math.floor((high - low)/2);

            const rowIdx = Math.floor(mid / matrix[0].length);
            const colIdx = mid % matrix[0].length;
            const element = matrix[rowIdx][colIdx];
            //console.log("indices = ", low, mid, high, `matrix[${rowIdx}][${colIdx}]`, element);
            if (element === target) {
                return true;
            }
            if (target > element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
