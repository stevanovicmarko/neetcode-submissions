class Solution {
    public static String getAnagramHash(String str) {
        var histogram = new int[26];
        for (var c : str.toCharArray()) {
            histogram[c - 'a']++;
        }
        return Arrays.toString(histogram);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (var str : strs) {
            var hash = getAnagramHash(str);
            map.merge(hash, new ArrayList<>(Arrays.asList(str)), (oldList, newList) -> {
                oldList.addAll(newList);
                return oldList;
            });
        }
        return new ArrayList<>(map.values());
    }
}
