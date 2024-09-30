import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a = 0;
        
        for (int[] command: commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
                       
            int[] buf = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(buf);
            answer[a++] = buf[k-1];
            
        }
        
        
        return answer;
    }
}