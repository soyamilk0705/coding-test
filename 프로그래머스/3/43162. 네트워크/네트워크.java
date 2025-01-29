
import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                answer++;
                dfs(computers, i);
            }
        }
        
        return answer;
    }
    
    static void dfs(int[][] computers, int start){
        visited[start] = true;
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i] && computers[start][i] == 1){
                dfs(computers, i);
            }
        }
    }
}