import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() == 1){
            return 1;
        }
        int answer = s.length();
        
        for(int step=1; step<=s.length()/2; step++){
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            String prefix = s.substring(0, step);
            
            for(int j=step; j<s.length(); j+=step){
                int len = Math.min(j+step, s.length());
                String str = s.substring(j, len);
                
                if(str.equals(prefix)){
                    cnt++;
                } else{
                    if(cnt > 1){
                        sb.append(cnt);
                    }
                    sb.append(prefix);
                    
                    cnt = 1;
                    prefix = str;
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