class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ""
        
        start, end = 0, 0
        
        def expand(left, right):
            # Expand outwards as long as the characters match and indices are valid
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            # Return the length of the palindrome found
            # (right - left - 1) because the loop stops after left/right go 1 step too far
            return right - left - 1

        for i in range(len(s)):
            # Case 1: Odd length palindromes (center is a single character, e.g., "aba")
            len1 = expand(i, i)
            
            # Case 2: Even length palindromes (center is between two characters, e.g., "abba")
            len2 = expand(i, i + 1)
            
            # Get the maximum length found from the current center(s)
            max_len = max(len1, len2)
            
            # If we found a longer palindrome, update our tracking boundaries
            if max_len > (end - start + 1):
                start = i - (max_len - 1) // 2
                end = i + max_len // 2
                
        return s[start:end + 1]