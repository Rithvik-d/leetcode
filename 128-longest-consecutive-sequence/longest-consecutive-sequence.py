class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
            
        # Convert list to a set for O(1) lookups
        num_set = set(nums)
        longest_streak = 0
        
        for num in num_set:
            # Check if 'num' is the start of a sequence
            if num - 1 not in num_set:
                current_num = num
                current_streak = 1
                
                # Incrementally look for the rest of the sequence
                while current_num + 1 in num_set:
                    current_num += 1
                    current_streak += 1
                
                # Track the longest sequence seen so far
                longest_streak = max(longest_streak, current_streak)
                
        return longest_streak