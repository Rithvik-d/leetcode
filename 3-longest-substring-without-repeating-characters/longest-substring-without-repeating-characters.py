class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Dictionary to store the last seen index of each character
        char_map = {}
        left = 0
        max_length = 0
        
        for right, char in enumerate(s):
            # If the character is already in the window, move the left pointer
            if char in char_map and char_map[char] >= left:
                left = char_map[char] + 1
            
            # Update the last seen index of the character
            char_map[char] = right
            
            # Calculate the current window length and update max_length
            max_length = max(max_length, right - left + 1)
            
        return max_length