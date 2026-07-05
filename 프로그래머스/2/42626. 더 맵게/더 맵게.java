import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scov : scoville){
            pq.offer(scov);
        }
        
        int cnt = 0;
        
        while(pq.size() > 1 && pq.peek() < K){
            int s = pq.poll();
            int c = pq.poll();
            int sum = s + (c * 2);
            pq.offer(sum);
            cnt++;
        }
        
        if(pq.size() < 2 && pq.peek() < K){
            return -1;
        }
        
        return cnt; 
    }
}