import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = name.length() - 1;
    
        for(int i=0; i<len; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 A가 끝나는 지점 찾기
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }

            move = Math.min(move, (i * 2) + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }
        
        answer += move;

        return answer;
    }
}