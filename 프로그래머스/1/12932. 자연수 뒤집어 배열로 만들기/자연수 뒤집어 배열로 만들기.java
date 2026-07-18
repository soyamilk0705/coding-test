import java.util.*;

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = Integer.parseInt(str.substring(len-i-1, len-i));
        }
        
        
        return answer;
    }
}