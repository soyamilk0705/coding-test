class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dungeon(k, dungeons, 0);
        return answer;
    }
    
    static void dungeon(int k, int[][] dungeons, int n){
        for(int i=0; i<dungeons.length; i++){
            if(visited[i] || dungeons[i][0] > k){
                continue;
            }
            visited[i] = true;
            dungeon(k - dungeons[i][1], dungeons, n+1);
            visited[i] = false;
        }
        
        answer = Math.max(answer, n);
        
    }
}