import java.util.*;

class Solution {
    class Process {
        int priority;
        int location;
        
        public Process(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }
        
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        while(!queue.isEmpty()){
            Process process = queue.poll();
            
            if(process.priority == priorities[idx]){
                answer++;
                idx--;
                if(process.location == location){
                    break;
                } 
            } else{
                queue.offer(process);
            }
            
        }
        
        
        return answer;
    }
}