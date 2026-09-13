import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        if (t.length() == 0) return "";


        HashMap<Character,Integer> need = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0; int right = 0;
        int n = s.length();
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        int startInd = -1;
        int needCnt = need.size();
        HashMap<Character,Integer> window = new HashMap<>();

        while(right<n){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);

            if(need.containsKey(c) && window.get(c).equals(need.get(c))){
                have++;
            }
            

            while(have==needCnt){
                int temp = (right - left + 1);
                if(temp<minLen){
                    minLen = temp;
                    startInd = left;
                }
                
                //Shrink
                char cl = s.charAt(left);
                window.put(cl,window.get(cl)-1);
                if(need.containsKey(cl) && window.get(cl)<need.get(cl)){
                    have--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startInd, startInd + minLen);
    }

//     public String minWindow(String s, String t) {

//     if (t.length() == 0) return "";
//     if (s.length() < t.length()) return "";

//     HashMap<Character, Integer> need = new HashMap<>();

//     for (char c : t.toCharArray()) {
//         need.put(c, need.getOrDefault(c, 0) + 1);
//     }

//     int left = 0;
//     int right = 0;

//     int have = 0;
//     int needCnt = need.size();

//     int minLen = Integer.MAX_VALUE;
//     int startInd = -1;

//     HashMap<Character, Integer> window = new HashMap<>();

//     while (right < s.length()) {

//         char c = s.charAt(right);

//         window.put(c, window.getOrDefault(c, 0) + 1);

//         if (need.containsKey(c)
//                 && window.get(c).equals(need.get(c))) {
//             have++;
//         }

//         while (have == needCnt) {

//             int len = right - left + 1;

//             if (len < minLen) {
//                 minLen = len;
//                 startInd = left;
//             }

//             char cl = s.charAt(left);

//             window.put(cl, window.get(cl) - 1);

//             if (need.containsKey(cl)
//                     && window.get(cl) < need.get(cl)) {
//                 have--;
//             }

//             left++;
//         }

//         right++;
//     }

//     return minLen == Integer.MAX_VALUE
//             ? ""
//             : s.substring(startInd, startInd + minLen);
// }
}
