import java.util.*;

class Solution {
    static List<String> dictionary = new ArrayList<>();
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        
        dfs(0, "");
        
        return dictionary.indexOf(word) + 1;
    }
    
    public void dfs(int len, String now){
        if(len > 5){
            return;
        }
        
        if(!now.isEmpty()){
            dictionary.add(now);
        }
        
        for(int i=0; i<5; i++){
            dfs(len+1, now + words[i]);
        }
    }
}