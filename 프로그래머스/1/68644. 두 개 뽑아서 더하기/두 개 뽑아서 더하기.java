import java.util.*;

class Solution {
    private static Set<Integer> result = new HashSet<>();
    
    public int[] solution(int[] numbers) {
        int[] answer;
        
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                result.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = new int[result.size()];
        int i=0;
        
        Iterator iter = result.iterator();
        while(iter.hasNext()){
            answer[i] = (int)iter.next();
            i++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
}