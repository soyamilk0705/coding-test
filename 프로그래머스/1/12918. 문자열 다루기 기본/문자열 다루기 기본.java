import java.util.*;

class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6){
            return false;
        }
        
        char[] ch = s.toCharArray();
        for(char c: ch){
           if (c < '0' || c > '9'){
                return false;
           }
            continue;
        }
        
        
        return true;
    }
}