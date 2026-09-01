class Solution {
    /**
     * @param {string} s
     * @return {number}
     */
    lengthOfLongestSubstring(s: string): number {
    let res = 0;
    let i = 0;
    let j = 0;
    const seen = new Set<string>();

    while (i < s.length) {
        const current = s[i];

        while (seen.has(current)) {
            seen.delete(s[j]);
            j++;
        }

        seen.add(current);

        res = Math.max(res, i - j + 1);
        i++;
    }

    return res;
    }
}
