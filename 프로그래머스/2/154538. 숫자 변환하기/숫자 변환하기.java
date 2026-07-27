import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        int[] total = new int[y+1];
        Arrays.fill(total, Integer.MAX_VALUE);
        total[x] = 0;
        
        for(int i=x; i<=y; i++){
            if(total[i] == Integer.MAX_VALUE){
                continue;
            }
            
            if(i+n <= y){
                total[i+n] = Math.min(total[i]+1, total[i+n]);
            }
            
            if(i*2 <= y){
                total[i*2] = Math.min(total[i]+1, total[i*2]);
            }
            
            if(i*3 <= y){
                total[i*3] = Math.min(total[i]+1, total[i*3]);
            }
        }
        
        if(total[y] == Integer.MAX_VALUE){  
            return answer;
        }
        return total[y];
    }
}