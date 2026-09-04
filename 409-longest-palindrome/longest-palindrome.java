class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[128];
        
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }
        
        int length = 0;
        for (int count : charCount) {
            length += (count / 2) * 2;
        }
        
        // If there are leftover characters, place one in the middle
        if (length < s.length()) {
            length++;
        }
        
        return length;
    }
}