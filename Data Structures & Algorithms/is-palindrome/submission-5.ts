class Solution {
    isAlphanumeric = (str: string) => /^[a-z0-9]+$/i.test(str);
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s: string): boolean {
        let i = 0;
        let j = s.length - 1;
        while (i < j) {
            const l = s.charAt(i).toLowerCase();
            const r = s.charAt(j).toLowerCase();
            if (!this.isAlphanumeric(l)) {
                i++;
                continue;
            }
            if (!this.isAlphanumeric(r)) {
                j--;
                continue;
            }
            if (l !== r) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
