import java.util.*;

class Solution {
    public String solution(int[] numbers) {    
        StringBuilder sb = new StringBuilder();
        String[] numberStr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            numberStr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numberStr, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        
        for(String str : numberStr){
            sb.append(str);
        }
        
        if(sb.toString().charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    }
}