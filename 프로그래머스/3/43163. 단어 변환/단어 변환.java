import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public void dfs(int result, String now, String target, String[] words){
        if(now.equals(target)){
            answer = Math.min(result, answer);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i]){
                int cnt = 0;
                
                for(int j=0; j<words[i].length(); j++){
                    if(words[i].charAt(j) == now.charAt(j)){
                        cnt++;
                    }
                }
                
                if(cnt == words[i].length() - 1){
                    visited[i] = true;
                    dfs(result+1, words[i], target, words);
                    visited[i] = false;
                }
            }
            
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        
        dfs(0, begin, target, words);
       
       
        
        if(answer == Integer.MAX_VALUE){
            return 0;
        }
        
        return answer;
    }
}