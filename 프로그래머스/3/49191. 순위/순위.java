import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];
    
        for(int[] result : results){
            graph[result[0]][result[1]] = true;
        }
        
        for(int x=0; x<=n; x++){
            for(int i=0; i<=n; i++){
                for(int j=0; j<=n; j++){
                    if(graph[i][x] && graph[x][j]){
                        graph[i][j] = true;
                    }
                }
            }
        }
        
        for(int i=0; i<=n; i++){
            int cnt = 0;
            
            for(int j=0; j<=n; j++){
                if(graph[i][j] || graph[j][i]){
                    cnt++;
                }
            }
            
            if(cnt == n-1){
                answer++;
            }
        }
        
        return answer;
    }
}