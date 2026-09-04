import java.util.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.append(String.valueOf(n % 3));
            n /= 3;
        }
        
        int answer = 0;
        
        for(int i=0; i<sb.length(); i++){
            int num = (int) sb.charAt(i) - '0';
            int tmp = 1;
            
            for(int j=0; j<sb.length() - i - 1; j++){
                tmp *= 3;   
            }
            
            answer += num * tmp;
        }
        
        return answer;
    }
}