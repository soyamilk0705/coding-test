import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String parti : participant){
           map.put(parti, map.getOrDefault(parti, 0) + 1);
        }
        
        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i])){
                map.put(completion[i], map.get(completion[i]) - 1);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}