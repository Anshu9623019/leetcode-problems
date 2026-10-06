class Solution {
    public long minOperations(int[] nums) {
        long ans = 0; // Use long to prevent integer overflow for larger sums
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                ans += nums[i - 1] - nums[i];
            }
        }
        
        return ans;
    }
}