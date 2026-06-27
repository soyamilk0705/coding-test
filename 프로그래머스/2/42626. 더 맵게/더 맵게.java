import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scov : scoville){
            pq.offer(scov);
        }
        
        while(pq.size() >= 2 && pq.peek() < K){
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + (b * 2);
            pq.offer(sum);
            answer++;
        }
        
        if(pq.peek() >= K){
            return answer;
        }
    
        return -1;
    }
}