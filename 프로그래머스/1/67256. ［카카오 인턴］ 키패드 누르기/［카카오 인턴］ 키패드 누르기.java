import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        for(int num : numbers){
            num = (num == 0) ? 11 : num;
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                left = num;
            } else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right = num;
            } else {
                int row = (num - 1) / 3;
                int col = (num - 1) % 3;
                
                int lr = (left - 1) / 3;
                int lc = (left - 1) % 3;
                
                int rr = (right - 1) / 3;
                int rc = (right - 1) % 3;
                
                int ld = Math.abs(lr - row) + Math.abs(lc - col);
                int rd = Math.abs(rr - row) + Math.abs(rc - col);
                
                if(ld < rd){
                    answer += "L";
                    left = num;
                } else if(ld > rd){
                    answer += "R";
                    right = num;
                } else{
                    if(hand.equals("left")){
                        answer += "L";
                        left = num;
                    } else{
                        answer += "R";
                        right = num;
                    }
                }
            } 
        }
        
        return answer;
    }
}