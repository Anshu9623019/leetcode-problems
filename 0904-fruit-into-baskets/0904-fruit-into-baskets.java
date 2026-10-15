class Solution {
    public int totalFruit(int[] fruits) {
        int k = 2;

        HashMap<Integer,Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = fruits.length;
        int ans = 0;
        while(r<n){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            while(mp.size()>2){
                int ele = fruits[l];
                if(mp.get(ele)==1){
                    mp.remove(ele);
                }else{
                    mp.put(ele,mp.get(ele)-1);
                }
                l++;              
            }

            ans = Math.max(ans,r-l+1);
           r++; 
        }
        return ans;
    }
}