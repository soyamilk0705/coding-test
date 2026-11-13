import java.util.*;

class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int cnt = 0;
        
        while(!s.equals("1")){
            for(char c : s.toCharArray()){
                if(c == '0'){
                    zeroCnt++;
                }
            }
            s = s.replace("0", "");
            int len = s.length();
            s = Integer.toBinaryString(len);
            cnt++;
        }
        
        
        return new int[]{cnt, zeroCnt};
    }
}