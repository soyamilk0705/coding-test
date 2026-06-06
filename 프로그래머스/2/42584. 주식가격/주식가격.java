import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<prices.length; i++){
            queue.offer(prices[i]);
        }
        
        int idx = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            int cnt = 0;
            
            for(int i=idx+1; i<prices.length; i++){
                if(!queue.isEmpty()){
                    int next = prices[i];
                    cnt++;
                    if(now > next){
                        break;
                    }
                }
            }
            
            
            answer[idx++] = cnt; 
            
        }
        
        
        return answer;
    }
}