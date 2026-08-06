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
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    visited[i][j] = true;
                    numberOfArea++;
                    int size = dfs(m, n, picture, i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int dfs(int m, int n, int[][] picture, int x, int y){
        int cnt = 1;
        
        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && picture[x][y] == picture[nx][ny]){
                visited[nx][ny] = true;
                cnt += dfs(m, n, picture, nx, ny);
                
            }
        }
        return cnt;
    }
}