import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            int cnt = 1;
            String prev = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            
            for(int j=i; j<s.length(); j+=i){
                String cur = s.substring(j, Math.min(j+i, s.length()));
                if(prev.equals(cur)){
                    cnt++;
                } else{
                    if(cnt > 1){
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    cnt = 1;
                    prev = cur;
                }
                
            }
            
            if(cnt > 1){
                sb.append(cnt);
            }
            sb.append(prev);
            answer = Math.min(sb.length(), answer);
        }
        
        return answer;
    }
}