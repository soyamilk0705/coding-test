import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> numberList = new ArrayList<>();
        
        for(int num : numbers){
            numberList.add(String.valueOf(num));
        }
        
        numberList.sort((a, b) -> (b+a).compareTo(a+b));
        
        for(String num : numberList){
            answer += num;
        }
        
        if(answer.startsWith("0")){
            return "0";
        }
        
        
        return answer;
    }
}