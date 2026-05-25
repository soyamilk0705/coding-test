import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int s = commands[i][0] - 1;
            int e = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            List<Integer> tmp = new ArrayList<>();
            for(int j=s; j<=e; j++){
                tmp.add(array[j]);
            }
            
            Collections.sort(tmp);
            answer[i] = tmp.get(k);
        }
        
        
        return answer;
    }
}