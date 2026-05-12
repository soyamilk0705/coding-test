import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int step=1; step<=s.length()/2; step++){
            StringBuilder sb = new StringBuilder();
            
            String prev = s.substring(0, step);
            int cnt = 1;
            
            for(int j=step; j<s.length(); j+=step){
                int end = Math.min(j+step, s.length());
                String current = s.substring(j, end);
                
                if(prev.equals(current)){
                    cnt++;
                } else {
                    if(cnt > 1){
                        sb.append(cnt);
                    }
                    
                    sb.append(prev);
                    prev = current;
                    cnt = 1;
                }
            }
            
            if(cnt > 1){
                sb.append(cnt);
            }
            
            sb.append(prev);
            answer = Math.min(answer, sb.length());
            
        }
        
        return answer;
    }
}