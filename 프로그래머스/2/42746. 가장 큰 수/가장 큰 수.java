import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> numList = new ArrayList<>();
        
        for(int num : numbers){
            numList.add(String.valueOf(num));
        }
        
        numList.sort((a, b) -> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        
        for(String num : numList){
            sb.append(num);
        }
        
        if(sb.toString().startsWith("0")){
            return "0";
        }
        
        return sb.toString();
    }
}