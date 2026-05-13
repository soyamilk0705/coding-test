import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        System.out.println('a' + 0);
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' '){
                answer += ' ';
            } else if(Character.isUpperCase(arr[i])){
                answer += (char) ((arr[i] - 'A' + n) % 26 + 'A');
            } else {
                // 122 - 97 =25
                answer += (char) ((arr[i] - 'a' + n) % 26 + 'a');
            }
            
            
        }
        
        
        return answer;
    }
}