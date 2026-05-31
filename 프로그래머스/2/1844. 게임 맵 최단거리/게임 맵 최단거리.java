import java.util.*;

class Point {
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] dist = new int[n][m];
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            
            if(now.x == n - 1 && now.y == m - 1){
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1){
                    maps[nx][ny] = 0;
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        
        if(dist[n - 1][m - 1] == 0){
            return -1;
        } else{
            return dist[n - 1][m - 1];
        }
        
    }
}