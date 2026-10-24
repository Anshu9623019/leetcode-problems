class Solution {
    public String reorganizeString(String s) {
       HashMap<Character, Integer> characterFrequencyMap = new HashMap<>();
        //store the count of each character into a hashmap.
        for(char ch : s.toCharArray()){
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0)+1);
        }
        
        //maxHeap of character which prioritizes a character based on the number of count it has in map.
        PriorityQueue<Character> charMaxHeap = new PriorityQueue<>((a,b) -> characterFrequencyMap.get(b)-characterFrequencyMap.get(a));
        
        //addAll key values of a map into charMaxHeap.
        charMaxHeap.addAll(characterFrequencyMap.keySet());
        
        StringBuilder resultString = new StringBuilder("");
        
        //since we are adding the two character in this loop. We are making sure that atleast two character exists in the heap.
        while(charMaxHeap.size()>1){
            char firstMaxCountChar = charMaxHeap.remove(); //remove char from heap.
            char secondMaxCountChar = charMaxHeap.remove(); //remove char from heap.
            
            //append the max char and second max char to the resultString.
            resultString.append(firstMaxCountChar).append(secondMaxCountChar);
            
            //decrement the count of firstMaxChar in map.
            characterFrequencyMap.put(firstMaxCountChar, characterFrequencyMap.get(firstMaxCountChar)-1);
            
            //decrement the count of secondMaxChar in map.
            characterFrequencyMap.put(secondMaxCountChar, characterFrequencyMap.get(secondMaxCountChar)-1);
            
            //check if the first_max_character is still present in the map after appending to result string.
            if(characterFrequencyMap.get(firstMaxCountChar)>0){
              charMaxHeap.add(firstMaxCountChar);
            }
            //check if the second_max_character is still present in the map after appending to result string.
            if(characterFrequencyMap.get(secondMaxCountChar)>0){
              charMaxHeap.add(secondMaxCountChar);
            }
        }
        
        //here's the end crucial logic part:
        if(!charMaxHeap.isEmpty()){
            char last = charMaxHeap.remove();
            if(characterFrequencyMap.get(last)>1) //last character count would be always greater than 1 if it's repeatitive.
                return "";
            
            resultString.append(last);
        }
        
        return resultString.toString();
        
    }
}