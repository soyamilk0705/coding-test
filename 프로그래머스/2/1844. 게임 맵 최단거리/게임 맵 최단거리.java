import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int maxX, maxY;
    
    public int solution(int[][] maps) {
        int answer = 0;
        maxX = maps.length;
        maxY = maps[0].length;
        
        int[][] visited = new int[maxX][maxY];
        bfs(maps, visited);
        
        answer = visited[maxX-1][maxY-1];
        
        if(answer == 0){
            return -1;
        }
        
        return answer;
        
    }
    
    static void bfs(int[][] maps, int[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            int x = current[0];
            int y = current[1];
            
            for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

                if(nx >= 0 && ny >= 0 && nx < maxX && ny < maxY && maps[nx][ny] == 1 && visited[nx][ny] == 0){
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }    
            }
        }
    }
}