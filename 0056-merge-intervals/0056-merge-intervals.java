class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1){
            return intervals;
        }

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int pStart = intervals[0][0];
        int pEnd = intervals[0][1];

        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while(i<n){
            if(pEnd>=intervals[i][0]){
                pEnd = Math.max(pEnd,intervals[i][1]);
            }else{
        
                ans.add(new int[]{pStart,pEnd});
                pStart = intervals[i][0];
                pEnd = intervals[i][1];
            }
            i++;
        }
        
        ans.add(new int[]{pStart,pEnd});  

        return ans.toArray(new int[0][1]);
    }
}