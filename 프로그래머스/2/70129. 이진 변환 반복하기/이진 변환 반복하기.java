import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int sLength = 0;
        int zeroCount = 0;
        
        while(!s.equals("1")){
            answer[1] += s.length();
            s = s.replace("0", "");
            sLength = s.length();
            s = Integer.toBinaryString(sLength);
            answer[0]++;
            answer[1] -= sLength;
        }
        
        
       
        return answer;
    }
}