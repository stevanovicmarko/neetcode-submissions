class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs: string[]): string[][] {

        const store = {};
        for (const str of strs) {
            const sortedStr = str.split('').sort((a, b) => a.localeCompare(b)).join('');
            if (store[sortedStr]) {
                store[sortedStr].push(str);
            } else {
                store[sortedStr] = [str];
            }
        }
        return Object.values(store);
    }
}
