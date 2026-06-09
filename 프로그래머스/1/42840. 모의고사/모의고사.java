import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        int oneCnt = 0;
        int twoCnt = 0;
        int threeCnt = 0;
        
        
        for(int i=0; i<answers.length; i++){
            if(one[i % 5] == answers[i]){
                oneCnt++;
            }
            if(two[i % 8] == answers[i]){
                twoCnt++;
            }
            if(three[i % 10] == answers[i]){
                threeCnt++;
            }
        }
    
        int max = Math.max(oneCnt, Math.max(twoCnt, threeCnt));
        
        if(oneCnt == max){
            answer.add(1);
        }
        if(twoCnt == max){
            answer.add(2);
        }
        if(threeCnt == max){
            answer.add(3);
        }
        
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}