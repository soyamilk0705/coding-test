import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] value = new int[][]{
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] cnt = new int[3];
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                if(answers[i] == value[j][i % value[j].length]){
                    cnt[j]++;
                }
            }
        }
        
        int max = Arrays.stream(cnt).max().getAsInt();
        
        List<Integer> list = new ArrayList<>();
    
        for(int i=0; i<3; i++){
            if (cnt[i] == max){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}