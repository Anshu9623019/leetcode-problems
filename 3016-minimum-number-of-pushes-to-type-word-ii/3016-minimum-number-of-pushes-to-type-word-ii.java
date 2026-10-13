
    import java.util.*;

class Solution {
    public int minimumPushes(String word) {
       
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : word.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mp.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int ans = 0;
        int j = 0;
        for (Map.Entry<Character, Integer> entry : list) {
            int val = (j / 8) + 1; 
            ans += val * entry.getValue();
            j++;
        }
        
        return ans;
    }
}