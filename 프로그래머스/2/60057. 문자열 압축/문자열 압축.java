import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;
        
        // 기준 글자 정해서 다음 글자와 비교하는 방식
        // i는 기준 글자 마지막 인덱스, base는 기준 글자 : substirng(0, i)
        // j는 비교 글자 첫 인덱스, endIdx는 비교 글자 마지막 인덱스, compare은 비교 글자 : substring(j, endIdx)
        // count는 같은 글자 횟수
        for(int i=1; i<=s.length()/2; i++){
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i);
            
            for(int j=i; j<=s.length(); j+=i){
                int endIdx = Math.min(j+i, s.length());
                String compare = s.substring(j, endIdx);
                if(base.equals(compare)){
                    count++;
                } else{
                    if(count >= 2){
                        result.append(count);
                    }
                    result.append(base);
                    base = compare;
                    count = 1;
                }
            }
            
            result.append(base);
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}


