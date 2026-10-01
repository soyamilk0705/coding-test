import java.util.*;

class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int cnt = 0;
        
        while(!s.equals("1")) {
            int oneCnt = 0;
        
            for(char c : s.toCharArray()){
                if(c == '1'){
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }

            s = Integer.toBinaryString(oneCnt);
            cnt++;
        }
        
        
        return new int[]{cnt, zeroCnt};
    }
}