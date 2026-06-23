
import java.util.*;

class Solution {
    static List<String> dictionary = new ArrayList<>();
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        
        return dictionary.indexOf(word) + 1;
    }
    
    public void dfs(String str){
        if(str.length() > 5){
            return;    
        }
        
        if(!str.isEmpty()){
            dictionary.add(str);
        }
        
        for(int i=0; i<5; i++){
            dfs(str + words[i]);
        }
    }
}