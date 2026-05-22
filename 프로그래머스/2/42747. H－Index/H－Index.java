import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = Integer.MIN_VALUE;
        
        Arrays.sort(citations);
        
        // 0 1 3 5 6
        for(int i=0; i<=citations[citations.length-1]; i++){
            int upCnt = 0;
            int downCnt = 0;
            for(int j=0; j<citations.length; j++){
                if(citations[j] < i){
                    downCnt++;
                } else{
                    upCnt++;
                }
            }
            
            if(downCnt <= i && upCnt >= i){
                answer = Math.max(i, answer);
            }
        }
        
        return answer;
    }
}