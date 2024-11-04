import java.util.*;

class Solution {
    private static int answer = 0;
    
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = citations[citations.length-1];
        
        for(int h=0; h<max; h++){
            int hMax = 0;
            int hMin = 0;
            
            for(int i=0; i<citations.length; i++){
                if(citations[i] >= h){
                    hMax++;
                } else{
                    hMin++;
                }
            }
            
            if(hMax >= h && hMin <= h){
                System.out.println("h : " + h + " hMax : " + hMax + " hMin : " + hMin);
                answer = Math.max(answer, h);
            }
        }
        return answer;
    }
}