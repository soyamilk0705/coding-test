import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length();
        
        for(int i=0; i<name.length(); i++){
            answer += Math.min(
                'Z' - name.charAt(i) + 1,
                name.charAt(i) - 'A'
            );
            
            int aIdx = i+1;
            
            while(aIdx < name.length() && name.charAt(aIdx) == 'A'){
                aIdx++;
            }
            
            move = Math.min(move, i * 2 + name.length() - aIdx);
            move = Math.min(move, (name.length() - aIdx) * 2 + i);
            
        }
        
        return answer + move;
    }
}