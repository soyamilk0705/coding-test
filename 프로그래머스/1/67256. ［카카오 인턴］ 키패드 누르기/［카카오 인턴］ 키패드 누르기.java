import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        
        for(int num : numbers){
            int n = (num == 0) ? 11 : num;
            
            if(n == 1 || n == 4 || n == 7){
                answer += "L";
                left = n;
            } else if(n == 3 || n == 6 || n == 9){
                answer += "R";
                right = n;
            } else{
                int row = (n - 1) / 3;
                int col = (n - 1) % 3;
                
                int lr = (left - 1) / 3;
                int lc = (left - 1) % 3;
                
                int rr = (right - 1) / 3;
                int rc = (right - 1) % 3;
                
                int ld = Math.abs(lr - row) + Math.abs(lc - col);
                int rd = Math.abs(rr - row) + Math.abs(rc - col);

                if (ld < rd) {
                    answer += "L";
                    left = n;
                } else if (ld > rd) {
                    answer += "R";
                    right = n;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right = n;
                    } else {
                        answer += "L";
                        left = n;
                    }
                }
            }
        }
        
        
        return answer;
    }
}