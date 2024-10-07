import java.util.*;

class Solution {
    boolean solution(String s) {
        String upperValue = s.toUpperCase();
        char[] ch = upperValue.toCharArray();
        
        int pCount = 0, yCount = 0;
        
        for(char c: ch){
            if (c == 'P') pCount++;
            else if (c == 'Y') yCount++;
        }
        
        if (pCount == yCount) return true;
        
        return false;
    }
}