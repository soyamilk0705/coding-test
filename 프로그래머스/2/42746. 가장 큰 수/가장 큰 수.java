import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> nums = new ArrayList<>();
        
        for(int n : numbers){
            nums.add(String.valueOf(n));
        }
        
        nums.sort((a, b) -> (b+a).compareTo(a+b));
        
        for(String str : nums){
            answer += str;
        }
        
        if(answer.startsWith("0")){
            return "0";
        }
        
        
        return answer;
    }
}