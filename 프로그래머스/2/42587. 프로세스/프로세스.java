import java.util.*;

class Solution {
    static class Process {
        int order;
        int priority;
        
        public Process(int order, int priority){
            this.order = order;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        List<Integer> sortPri = new ArrayList<>();
        
        int priIdx = 0;
        
        
        for(int i=0; i<priorities.length; i++){
            Process p = new Process(i, priorities[i]);
            queue.add(p);
            sortPri.add(priorities[i]);
        }
        
        Collections.sort(sortPri, Comparator.reverseOrder());
        
        while(!queue.isEmpty()){
            Process p = queue.poll();
            
            if(p.priority == sortPri.get(priIdx)) {
                if(p.order == location){
                    return answer+1;
                } else {
                    answer++;
                    priIdx++;                
                }
            } else{
                queue.offer(p);
            }
        }
        
        
        
        return answer;
    }
}