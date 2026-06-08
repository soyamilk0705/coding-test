import java.util.*;

class Solution {
    public String solution(String p) {
        if(p.isEmpty()){
            return "";
        }
        
        int balance = 0;
        int idx = 0;
        
        // 균형잡인 문자열 u 찾기
        do {
            if(p.charAt(idx) == '('){
                balance++;
            } else{
                balance--;
            }
            idx++;
        } while(balance != 0);
        
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        // u 가 올바른 괄호 문자열인 경우
        if(isCorrect(u)){
            return u + solution(v);
        }
        
        // u 가 올바른 괄호 문자열이 아닌 경우
        StringBuilder sb = new StringBuilder();
        
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        
        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i) == '('){
                sb.append(")");
            } else{
                sb.append("(");
            }
        }
        
        return sb.toString();
    }
    
    public boolean isCorrect(String str){
        int count = 0;
        
        for(char c : str.toCharArray()){
            if(c == '('){
                count++;
            } else{
                count--;
            }
            
            if(count < 0){
                return false;
            }
        }
        
        return count == 0;
    }
}