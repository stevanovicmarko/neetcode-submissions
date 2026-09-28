public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastSeen.containsKey(current)) {
                // The Math.max guard prevents 'left' from jumping backward
                left = Math.max(left, lastSeen.get(current) + 1);
            }

            maxLength = Math.max(maxLength, right - left + 1);
            lastSeen.put(current, right);
        }

        return maxLength;
    }
}