import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>();
    
    public int solution(int[] priorities, int location) {
        int maxPri = 0;
        
        Queue<Character> charQue = new LinkedList<>();
        List<Character> result = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++){
            charQue.offer((char)('A' + i));
            list.add(priorities[i]);
            maxPri = changeMax();
        }
        
        while(!charQue.isEmpty()){
            char value = charQue.poll();
            int pri = list.remove(0);
            
            if(pri == maxPri){
                result.add(value);
                maxPri = changeMax();
            }else{
                charQue.offer(value);
                list.add(pri);
            }
            
        }
        
        
        return result.indexOf((char)('A' + location)) + 1;
    }
    
    
    static int changeMax(){
        int maxValue = 0;
        
        for(int i=0; i<list.size(); i++){
            maxValue = Math.max(maxValue, list.get(i));
        }
        
        return maxValue;
    }
}