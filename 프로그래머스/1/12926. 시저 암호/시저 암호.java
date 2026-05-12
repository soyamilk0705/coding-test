import java.util.*;

class Solution {
    // 'A' = 65,'Z' = 90 | 'a' = 97,  'z' = 122
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
    
        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(' ');
                continue;
            } else if(Character.isUpperCase(c) && c + n > 90){
                int t = n - ('Z' - c);
                sb.append((char) ('A' + t - 1));
            } else if(c + n > 122){
                int t = n - ('z' - c);
                sb.append((char) ('a' + t - 1));
            } else{
                sb.append((char) (c + n));
            }
        }
        
        return sb.toString();
    }
}