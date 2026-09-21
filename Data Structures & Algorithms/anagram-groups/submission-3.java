class Solution {
    public static String getAnagramHash(String str) {
        if (str == null) {
            return "";
        }

        // Create a bucket for each of the 26 lowercase alphabet letters
        int[] counts = new int[26];

        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++; // i hate this "trick"
        }

        // Hash the fixed 26-length frequency array in O(N) time
        return Arrays.toString(counts);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (var str: strs) {
            map.computeIfAbsent(getAnagramHash(str), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
