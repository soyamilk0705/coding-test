import java.util.*;

class Solution {
    static boolean[] visited;
    static int n;
    static int answer = 0;
    
    public void dfs(int k, int[][] dungeons, int now, int cnt){
        if(now == n){
            answer = Math.max(answer, cnt);
            return;
        }
    
        
        for(int i=0; i<n; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                cnt++;
                
                dfs(k-dungeons[i][1], dungeons, now+1, cnt);
                
                cnt--;
                visited[i] = false;
            } else{
                answer = Math.max(answer, cnt);
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(k, dungeons, 0, 0);

        return answer;
    }
}