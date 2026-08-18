import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            word = word.replace("aya", " ");
            word = word.replace("ye", " ");
            word = word.replace("woo", " ");
            word = word.replace("ma", " ");
            
            if(word.trim().isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}