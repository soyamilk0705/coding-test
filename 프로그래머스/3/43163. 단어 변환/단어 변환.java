import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        return answer;
    }
    
    static void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        
        String[] beginArr = begin.split("");
        
        for(int i=0; i<words.length; i++){
            if(visited[i]) continue;
            
            int temp = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    temp++;  
                }
            }
            
            if(temp == target.length() - 1){
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
        
        
    }
}