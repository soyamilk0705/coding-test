class Solution {
    static boolean[] visited;
    
    public void dfs(int idx, int n, int[][] computers){
        for(int i=0; i<n; i++){
            if(i == idx){
                continue;
            }
            
            if(!visited[i] && computers[idx][i] == 1){
                visited[i] = true;
                dfs(i, n, computers);
            } 
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, n, computers);
                answer++;
            }    
        }
        
        return answer;
    }
}