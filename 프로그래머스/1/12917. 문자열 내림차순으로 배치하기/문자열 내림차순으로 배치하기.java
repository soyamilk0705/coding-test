import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();        
        String[] strArr = s.split("");
        
        Arrays.sort(strArr);
        
        for(String st: strArr){
            sb.append(st);
        }
        
        return sb.reverse().toString();
    }
}