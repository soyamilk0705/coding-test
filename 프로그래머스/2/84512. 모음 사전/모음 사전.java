import java.util.*;

class Solution {
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {  
        dfs("", 0);
        return list.indexOf(word) + 1;
    }
    
    public void dfs(String now, int len){
        if(len > 5){
            return;
        }
        
        if(!now.isEmpty()){
            list.add(now);
        }
        
        for(int i=0; i<5; i++){
            dfs(now + words[i], len+1);
        }
        
    }
}