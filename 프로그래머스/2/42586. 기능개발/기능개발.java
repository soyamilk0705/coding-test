import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<speeds.length; i++){
            int remainPro = 100 - progresses[i];
            
            if(remainPro % speeds[i] != 0){
                queue.offer(remainPro / speeds[i] + 1);
            } else{
                queue.offer(remainPro / speeds[i]);
            }
        }
        
        int day = queue.poll();
        int value = 1;
        
        while(!queue.isEmpty()){
            int nextDay = queue.poll();
            
            if(nextDay > day){
                answer.add(value);
                day = nextDay;
                value = 1;
            } else{
                value++;
                continue;
            }
        }
        
        answer.add(value);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}