class Solution {
    public boolean isPalindrome(String s) {
        String testString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = testString.length() - 1;
        //System.out.println(testString);
        while (i <= j) {
            if(testString.charAt(i) != testString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
