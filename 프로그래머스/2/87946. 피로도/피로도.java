class Solution {
    static int n;
    static boolean[] visited;
    static int answer = 0;
    
    public void dfs(int k, int level, int[][] dungeons){
        answer = Math.max(answer, level);
        
        for(int i=0; i<n; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(k-dungeons[i][1], level+1, dungeons);
                visited[i] = false;
            }
            
        }
        
        
    }
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(k, 0, dungeons);
        
        return answer;
    }
}