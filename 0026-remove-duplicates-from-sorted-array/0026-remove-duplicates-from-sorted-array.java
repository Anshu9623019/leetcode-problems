class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;
        int n = nums.length;
        
        while(i<n && j<n){
            if(nums[i]==nums[j]){
                i++;
            }else{
                int temp = nums[j+1];
                nums[j+1] = nums[i];
                nums[i] = temp;
                j++;
                i++;
            }
        }

        return j+1;

    }
	    
}