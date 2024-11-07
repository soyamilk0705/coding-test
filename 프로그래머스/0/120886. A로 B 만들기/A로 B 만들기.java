import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] afterArr = after.toCharArray();
        char[] beforeArr = before.toCharArray();
        List<Character> list = new ArrayList<>();
        
        for(int i=0; i<beforeArr.length; i++){
            list.add(beforeArr[i]);
        }
        
        for(int i=0; i<afterArr.length; i++){
            if(list.contains(afterArr[i])){
                int index = list.indexOf(afterArr[i]);
                list.remove(index);
            }
        }
        
        if(list.isEmpty()){
            return 1;
        }
        
        
        
        
        return 0;
    }
}