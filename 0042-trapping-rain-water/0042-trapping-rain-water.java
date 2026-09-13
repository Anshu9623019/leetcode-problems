class Solution {
    public int trap(int[] height) { 

        int total =0,leftMax=0, rightMax=0;
        int i = 0, j = height.length-1;
        while(i<j){
            if(height[i]<=height[j]){
                 leftMax = Math.max(leftMax,height[i]);
                 total += leftMax - height[i];
                 i++;
            }else{
                rightMax = Math.max(rightMax,height[j]);
                total += rightMax - height[j];
                j--;
            }
        }

        return total;
    }
}