import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static List<String> answer = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(int len : course){
            map = new HashMap<>();
            
            for(String order : orders){
                if(order.length() < len){
                    continue;
                }
                
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                dfs("", len, 0, arr);
            }
            
            int max = 0;
            for(String key : map.keySet()){
                max = Math.max(max, map.get(key));
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
    
    public void dfs(String now, int len, int idx, char[] arr){
        if(now.length() == len){
            map.put(now, map.getOrDefault(now, 0) + 1);
            return;
        }
        
        for(int i=idx; i<arr.length; i++){
            dfs(now + arr[i], len, i+1, arr);
        }
    }
}