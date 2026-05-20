import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, List<String>> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            if(map.containsKey(cloth[1])){
                List<String> values = map.get(cloth[1]);
                values.add(cloth[0]);
                map.put(cloth[1], values);
            } else{
                map.put(cloth[1], new ArrayList<>(List.of(cloth[0])));
            }
            answer++;
        }
        
        if(map.size() == 1){
            return answer;
        }
        
        int tmp = 1;
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            tmp *= (list.size() + 1);
        }
        
        return tmp - 1;
    }
}