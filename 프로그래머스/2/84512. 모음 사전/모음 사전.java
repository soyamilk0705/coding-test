import java.util.*;

class Solution {
    private List<String> list = new ArrayList<>();
    private String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        makeDictionary("", 0);
        return list.indexOf(word);
    }
    
    
    public void makeDictionary(String result, int len){
        list.add(result);
        
        if (len == 5) return;
        
        for (int i=0; i<5; i++){
            makeDictionary(result + words[i] , len + 1);
            // makeDicionary("A", 1) - makeDictionary("AA", 2) - makeDictionary("AAA", 3)
            //                                                 - makeDictionary("AAE", 3)
            //                       - makeDictionary("AE", 2) - makeDictionary("AEA", 3)
            // makeDictionary("E", 1)
            // makeDictionary("I", 1)
            // makeDictionary("O", 1)
            // makeDictionary("U", 1)
            
        }
        
    }
}