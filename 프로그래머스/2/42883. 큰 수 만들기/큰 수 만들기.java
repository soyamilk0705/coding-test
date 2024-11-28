import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] array = number.toCharArray();
        
        int len = number.length() - k;
    
        int start = 0;
        
        for(int i=0; i<len; i++){
            char max = '0';
            for(int j=start; j<=i+k; j++){
                if(array[j] > max){
                    max = array[j];
                    start = j + 1;
                }
            }
            
            sb.append(Character.toString(max));
        }
    
            
        return sb.toString();
    }
}