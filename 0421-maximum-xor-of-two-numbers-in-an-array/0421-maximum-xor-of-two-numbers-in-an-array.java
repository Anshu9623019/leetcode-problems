class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2]; // index 0 for bit '0', index 1 for bit '1'
    }
    
    class Trie {
        TrieNode root = new TrieNode();
        
        // Insert number into the trie bit by bit (from MSB to LSB)
        public void insert(int num) {
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit];
            }
        }
        
        // Find the maximum possible XOR for a given number with numbers already in the trie
        public int getMaxXor(int num) {
            TrieNode curr = root;
            int maxXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggledBit = 1 - bit; // We want the opposite bit to maximize XOR
                
                if (curr.children[toggledBit] != null) {
                    maxXor |= (1 << i); // Set this bit in our result
                    curr = curr.children[toggledBit];
                } else {
                    curr = curr.children[bit]; // Fall back to the same bit if opposite isn't available
                }
            }
            return maxXor;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int maxResult = 0;
        
        // Insert the first number
        trie.insert(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            // Find max XOR of nums[i] with any number inserted so far
            maxResult = Math.max(maxResult, trie.getMaxXor(nums[i]));
            // Insert current number into the trie for future lookups
            trie.insert(nums[i]);
        }
        
        return maxResult;
    }
}