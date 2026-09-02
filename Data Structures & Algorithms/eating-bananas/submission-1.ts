class Solution {
    /**
     * @param {number[]} piles
     * @param {number} h
     * @return {number}
     */
minEatingSpeed(piles: number[], h: number): number {
    let lowerBound = 1;
    let upperBound = piles.reduce((max, p) => (p > max ? p : max), 0);
    let res = upperBound;

    while (lowerBound <= upperBound) {
        const middle = lowerBound + Math.floor((upperBound - lowerBound) / 2);

        let total = 0;
        for (const pile of piles) {
            total += Math.ceil(pile / middle);
        }

        if (total > h) {
            lowerBound = middle + 1;
        } else {
            res = middle;
            upperBound = middle - 1;
        }
    }

    return res;
}
}
