import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char ch: s.toCharArray()){
            if(ch == ' '){
                answer += ch;
            } else if(ch >= 'a' && ch <= 'z'){  // 소문자인 경우
                answer += (char)('a' + (ch+n-'a') % 26);
            } else{     // 대문자인 경우
                answer += (char)('A' + (ch+n-'A') % 26);
            }
        }
        return answer;
    } 
}