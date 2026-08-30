import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        // A = 65
        
        for(char c : s.toCharArray()){
            if(c == ' '){
                answer += ' ';
            } else if(c >= 'A' && c <= 'Z'){
                answer += (char) ((c - 'A' + n) % 26 + 'A');
            } else{
                answer += (char) ((c - 'a' + n) % 26 + 'a');
            }
        }
        
        
        return answer;
    }
}