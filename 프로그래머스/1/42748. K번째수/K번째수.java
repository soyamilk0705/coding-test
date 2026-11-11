import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] comm : commands){
            int[] arr = Arrays.copyOfRange(array, comm[0]-1, comm[1]);
            
            Arrays.sort(arr);
            
            answer[idx++] = arr[comm[2]-1];
            
        }
        return answer;
    }
}