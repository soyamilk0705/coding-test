class Solution {
    static boolean[] visited;
    static int answer = 0;
    static int n;
    
    public void dfs(int[][] dungeons, int k, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i=0; i<n; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(dungeons, k - dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(dungeons, k, 0);
        
        return answer;
    }
}