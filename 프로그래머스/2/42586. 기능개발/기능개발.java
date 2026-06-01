import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<speeds.length; i++){
            int day = ((100 - progresses[i]) + speeds[i] - 1) / speeds[i];
            queue.add(day);
        }
        
       
        while(!queue.isEmpty()){
            int day = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty() && queue.peek() <= day){
                queue.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }
        

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}