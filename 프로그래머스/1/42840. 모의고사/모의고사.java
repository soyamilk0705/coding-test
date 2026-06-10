import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[][] solution = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] cnt = new int[3];
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                int n = solution[j].length;
                if(answers[i] == solution[j][i % n]){
                    cnt[j]++;
                }
            }
        }
        
        int max = Arrays.stream(cnt).max().getAsInt();
        
        for(int i=0; i<cnt.length; i++){
            if(cnt[i] == max){
                answer.add(i+1);
            }
        }
        
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}