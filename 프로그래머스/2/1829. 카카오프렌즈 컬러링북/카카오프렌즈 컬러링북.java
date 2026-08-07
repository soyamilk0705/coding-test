import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
       
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int size = 0;
                
                if(!visited[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    size += bfs(queue, picture, m, n);
                }
                
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(Queue<int[]> queue, int[][] picture, int m, int n){
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && picture[nx][ny] == picture[x][y]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}