class Solution {
    public int removeDuplicates(int[] nums) {
        // int cnt = 1;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i-1]==nums[i]){
        //         continue;
        //     }
        //     cnt++;
        // }
        // int arr[] = new int[cnt];
        // arr[0] = nums[0];
        // int k = 1;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i-1]==nums[i]){
        //         continue;
        //     }
        //     arr[k++] = nums[i];
        // }
        // for(int i=0;i<cnt;i++){
        //     nums[i] = arr[i];
        // }
        // return cnt;

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