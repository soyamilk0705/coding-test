import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String oper : operations){
            if(oper.startsWith("I")){
                minQue.offer(Integer.parseInt(oper.substring(2)));
                maxQue.offer(Integer.parseInt(oper.substring(2)));
            } else if(!minQue.isEmpty() && oper.equals("D -1")){
                int n = minQue.poll();
                maxQue.remove(n);
            } else if(!maxQue.isEmpty() && oper.equals("D 1")){
                int n = maxQue.poll();
                minQue.remove(n);
            }
        }
        
        if(minQue.isEmpty() && maxQue.isEmpty()){
            return new int[]{0, 0};
        }
        
        
        return new int[] {maxQue.poll(), minQue.poll()};
    }
}