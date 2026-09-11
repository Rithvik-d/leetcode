class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int i = 2; // Pointer for the next valid position
        for (int j = 2; j < nums.length; j++) {
            // Compare current element with the element two positions behind the write index
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i;
    }
}