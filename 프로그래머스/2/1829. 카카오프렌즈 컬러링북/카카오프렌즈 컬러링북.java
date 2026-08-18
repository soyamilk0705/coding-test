import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        
        boolean[][] visited = new boolean[m+1][n+1];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int cnt = 1;
                    
                    while(!queue.isEmpty()){
                        int[] now = queue.poll();
            
                        for(int z=0; z<4; z++){
                            int nx = now[0] + dx[z];
                            int ny = now[1] + dy[z];
                
                            if(nx >= 0 && ny >=0 && nx < m && ny < n && !visited[nx][ny] && picture[now[0]][now[1]] == picture[nx][ny]){
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                                cnt++;
                            }
                        }
                    }
                    
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);

                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}