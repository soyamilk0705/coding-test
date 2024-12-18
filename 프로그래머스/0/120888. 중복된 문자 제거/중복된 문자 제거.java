import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = my_string.split("");
        Set<String> set = new LinkedHashSet<>(Arrays.asList(strArr));
        
        Iterator iter = set.iterator();
        
        while(iter.hasNext()){
            sb.append(iter.next());
        }
        
        return sb.toString();
    }
}