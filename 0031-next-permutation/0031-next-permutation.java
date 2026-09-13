class Solution {
    public void nextPermutation(int[] nums) {

        // find index
        int n = nums.length;
        int i = n-1;
        int index = -1;

        while(i>0){
            if(nums[i-1]<nums[i]){
                index = i-1;
                break;
            }
            i--;
        }
        if(index == -1){
            reverse(nums,0,n-1);
            return;
        }
        int j = n-1;
        while(j>index){
           if(nums[j]>nums[index]){
            int temp = nums[j];
            nums[j] = nums[index];
            nums[index] = temp;
            break;
           }
           j--;
        }

        reverse(nums,index+1,n-1);
    }

    void reverse(int []nums,int i,int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}