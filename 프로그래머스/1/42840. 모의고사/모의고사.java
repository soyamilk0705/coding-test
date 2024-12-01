import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] grades = new int[3];
    
        for(int i=0; i<answers.length; i++){
            if(answers[i] == person1[i%5]){
                grades[0]++;
            }
            if(answers[i] == person2[i%8]){
                grades[1]++;
            }
            if(answers[i] == person3[i%10]){
                grades[2]++;
            }
        }
        
        int max = Arrays.stream(grades).max().orElse(0);
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<grades.length; i++){
            if(grades[i] == max){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
}