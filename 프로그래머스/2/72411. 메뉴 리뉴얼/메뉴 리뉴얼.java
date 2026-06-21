import java.util.*;

class Solution {
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int len : course){
            map = new HashMap<>();
            
            for(String order : orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                
                if(arr.length >= len){
                    dfs(arr, "", 0, len);
                }
                
            }
            
            int max = 0;
            for(int count : map.values()){
                max = Math.max(max, count);
            }
            
            if(max < 2){
                continue;
            }
            
            for(String key : map.keySet()){
                if(map.get(key) == max){
                    answer.add(key);
                }
            }
            
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(char[] order, String cur, int idx, int target){
        if(cur.length() == target){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        
        for(int i=idx; i<order.length; i++){
            dfs(order, cur + order[i], i+1, target);
        }
    }
}