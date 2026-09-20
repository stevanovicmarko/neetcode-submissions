class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        var positionMap = new HashMap<Character, Integer>();

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            if (positionMap.containsKey(rChar)) {
                // move left pass the right
                left = Math.max(left, positionMap.get(rChar) + 1);
            }
            positionMap.put(rChar, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
