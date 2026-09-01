class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right= nums.length-1;
        while(left<right){
            int mid = left+ (right-left)/2;
            if(nums[mid+1]<nums[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}