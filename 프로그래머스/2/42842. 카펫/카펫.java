import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];
        
        for(int i=3; i<total; i++){
            int j = total / i;
            
            if(total % i  == 0 && j >= 3){
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);
                
                if (center == yellow){
                    answer[0] = col;
                    answer[1] = row;
                }
                
            }
        }
        
        return answer;
    }
}