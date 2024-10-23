import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i : prices){
            queue.offer(i);
        }
        
        int j = 0;
        
        while(!queue.isEmpty()){
            int value = queue.poll();
            int start = prices.length - queue.size();
            
            for(int i=start; i<prices.length; i++){
                answer[j]++;
                
                if(value > prices[i]){
                    break;
                } 
            }
            
            j++;
        }
        
        
        return answer;
    }
}