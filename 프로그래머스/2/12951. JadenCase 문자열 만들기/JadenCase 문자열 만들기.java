import java.util.*;
 
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        
        for(int i=0; i<arr.length; i++){
            String temp = arr[i];
            
            if(arr[i].length() == 0){
                answer += " ";
            } else{
                answer += temp.substring(0, 1).toUpperCase();
                answer += temp.substring(1, temp.length()).toLowerCase();
                answer += " ";
            }
        
        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
        
        return answer.substring(0, answer.length()-1);
    }
 
}
