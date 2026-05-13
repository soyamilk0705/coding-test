import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
      
        for(int step=1; step<=s.length()/2; step++){
            StringBuilder sb = new StringBuilder();
            String prefix = s.substring(0, step);
            int cnt = 1;
            
            for(int j=step; j<s.length(); j+=step){
                int len = Math.min(j+step, s.length());
                String cur = s.substring(j, len);
                
                if(cur.equals(prefix)){
                    cnt++;   
                } else{
                    if(cnt > 1){
                        sb.append(cnt);
                    }
                    
                    sb.append(prefix);
                    
                    prefix = cur;
                    cnt = 1;
                }
            }
            
            if(cnt > 1){
                sb.append(cnt);
            }
        
            sb.append(prefix);
            answer = Math.min(sb.length(), answer);
        }
        
        return answer;
    }
}