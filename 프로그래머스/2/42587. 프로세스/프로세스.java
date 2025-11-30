import java.util.*;

class Process{
    int idx;
    int value;
    
    public Process(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(i, priorities[i]));
        }
        
        while(!queue.isEmpty()){
            int max = 0;
        
            for(int i=0; i<queue.size(); i++){
                Process tmp = queue.poll();
                max = Math.max(max, tmp.value);
                queue.offer(tmp);
            }
            
            Process p = queue.poll();
        
            if(p.value == max){
                answer++;
                if(p.idx == location){
                    break;
                }
            } else{
                queue.offer(p);
            }
            
        }
        
        return answer;
    }
}