import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int time = (remain + speeds[i] - 1) / speeds[i];

            queue.offer(time);
        }
        
        int cnt = 1;
        int p = queue.poll();
        
        while(!queue.isEmpty()){
            if(queue.peek() <= p){
                cnt++;
                queue.poll();
            } else{
                list.add(cnt);
                cnt = 1;
                p = queue.poll();
            }
            
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}