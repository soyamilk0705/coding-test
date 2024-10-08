import java.util.*;

class Solution {
    public int solution(int n) {
        String strVal = "";
        int answer = 0;
        int multi = 1;
        
        while(n > 0){
            strVal = strVal + String.valueOf(n % 3);    
            n /= 3;
        }
        
        String[] strArr = strVal.split("");
        
        for(int i=strVal.length() - 1; i >= 0; i--){
            answer += Integer.parseInt(strArr[i]) * multi;
            multi *= 3;
        }
        
        // 라이브러리 사용법
        // Integer.toString(n, 3); // 10진법 -> 3진법
        // Integer.parseInt(n, 3); // 3진법 -> 10진법
        
        return answer;
    }
}