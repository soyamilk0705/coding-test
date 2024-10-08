import java.util.*;

class Solution {
    public int solution(String s) {
        String[] arrays = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<arrays.length; i++){
            
            if(s.contains(arrays[i])){
                s = s.replace(arrays[i], String.valueOf(i));
            }
        }
        
        
        return Integer.parseInt(s);
    }
}