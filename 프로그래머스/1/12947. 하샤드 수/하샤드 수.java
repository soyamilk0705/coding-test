import java.util.*;

class Solution {
    public boolean solution(int x) {
        int sum = String.valueOf(x)
            .chars()                // 문자열의 각 문자를 아스키 값으로 변환한 스트림 생성 (예: "348" -> [51, 52, 56])
            .map(m -> m - '0')      // 아크시 값에서 '0'의 아스키 값(48)을 빼서 숫자로 변환
            .sum();
        
        return x % sum == 0;
    }
}