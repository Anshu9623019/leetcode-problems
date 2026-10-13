
    import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] letterCounts = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            ++letterCounts[word.charAt(i) - 'a'];
        }
        Arrays.sort(letterCounts);
        int pushes = 0;
        for (int i = 0; i < 26; ++i) {
            pushes += (i / 8 + 1) * letterCounts[26 - i - 1];
        }
        return pushes;
    }
}