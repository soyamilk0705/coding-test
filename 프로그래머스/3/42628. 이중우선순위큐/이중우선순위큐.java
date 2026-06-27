import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> ascPQ = new PriorityQueue<>();
        PriorityQueue<Integer> descPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(String oper : operations){
            if(oper.startsWith("I")){
                int num = Integer.parseInt(oper.split(" ")[1]);
                ascPQ.offer(num);
                descPQ.offer(num);
            } else if(oper.equals("D 1")){
                if(!descPQ.isEmpty()){
                    int n = descPQ.poll();
                    ascPQ.remove(n);
                }
            } else {
                if(!ascPQ.isEmpty()){
                    int n = ascPQ.poll();
                    descPQ.remove(n);
                }
            }
        }
        
        if(ascPQ.isEmpty() || descPQ.isEmpty()){
           return new int[] {0, 0}; 
        }
        
        
        return new int[]{descPQ.poll(), ascPQ.poll()};
    }
}