import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;
        
        Queue<Integer> que = new LinkedList<Integer>();
        
        
        for(int i : priorities){
            que.add(i);
        }
        
        Arrays.sort(priorities);
        int size = priorities.length-1;
        
        while(!que.isEmpty()){
            Integer value = que.poll();

            if(value == priorities[size - answer]){
                answer++;
                l--;
                if(l < 0)
                    break;
            } else{
                que.add(value);
                l--;
                if(l < 0)
                    l = que.size() - 1;
            }
        
            
        }
        
    
        return answer;
    }
    
}