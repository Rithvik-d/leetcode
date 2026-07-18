class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Hash map to store the value and its corresponding index
        num_to_index = {}
        
        for i, num in enumerate(nums):
            complement = target - num
            
            # If the complement exists in the map, we found our pair
            if complement in num_to_index:
                return [num_to_index[complement], i]
            
            # Otherwise, store the current number and its index
            num_to_index[num] = i