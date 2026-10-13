class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int i  = 0;
        int j = 0;
        int n = word.length();
        int ans = 0;
        while(i<n){
            char ch = word.charAt(i);
            if(!mp.containsKey(ch)){
                j++;
                int val = (j -1 )/8 + 1;
                mp.put(ch,val);
            }
            System.out.println(ch+""+mp.get(ch));
            ans += mp.get(ch);
            i++;
        }
        return ans;
    }
}