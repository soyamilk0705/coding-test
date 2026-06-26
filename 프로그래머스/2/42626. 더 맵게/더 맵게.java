import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scov : scoville){
            pq.offer(scov);
        }
        
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            
            if(a >= K){
                break;
            }
            
            if(!pq.isEmpty()){
                int b = pq.poll();
                
                int sum = a + (b * 2);
                pq.offer(sum);
                answer++;
                
            } else{
                return -1;
            }
        }
        
        
        
        
        return answer;
    }
}