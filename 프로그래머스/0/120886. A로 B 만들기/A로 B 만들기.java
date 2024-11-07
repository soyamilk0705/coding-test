import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] afterArr = after.toCharArray();
        char[] beforeArr = before.toCharArray();
        
        Arrays.sort(afterArr);
        Arrays.sort(beforeArr);
        
        return new String(afterArr).equals(new String(beforeArr)) ? 1 : 0;
        
    }
}