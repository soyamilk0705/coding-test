import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] value = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] cnt = new int[3];
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                int len = i % value[j].length;
                
                if(answers[i] == value[j][len]){
                    cnt[j]++;
                }
            }
            
        }
        
        
        int max = Arrays.stream(cnt).max().getAsInt();
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            if(cnt[i] == max){
                answer.add(i+1);        
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
}