import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Base case: prefix sum 0 occurs once before iterating
        prefixSumCounts.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists in map, add its frequency to count
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }
            
            // Record current sum frequency
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}